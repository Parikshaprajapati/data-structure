public class allindex{
    public static void main(String[] args){
        int[] arr={0,20,100,30,40,100,50,60,100,100,100,110};
        System.out.println("all indeces of 100 : ");
        int[] idx=index(arr,0,100,0);
        for(int i=0;i<idx.length;i++)
        System.out.print(idx[i]+" ");
        index01(arr,0,100," ");

    }
    
//return type

    public static int[] index(int[] arr,int idx,int data,int count){
        if(idx==arr.length){
            int[] base=new int[count];
         return base;
        }
        if(arr[idx]==data)count++;
         int[] res=index(arr,idx+1,data,count);
         if(arr[idx]==data)
          res[count-1]=idx;
          return res;
    }

//void type

    public static void index01(int[] arr,int idx,int data,String ans){
        if(arr.length==idx){
            System.out.println();
            System.out.println(ans);
            return;
        }
        if(arr[idx]==data)
        index01(arr,idx+1,data,ans+String.valueOf(idx)+" ");
        else
        index01(arr,idx+1,data,ans);
    }
}
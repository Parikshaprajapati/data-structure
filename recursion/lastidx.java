public class lastidx{
    public static void main(String[] args){
        int[] arr={0,20,100,30,40,100,50,60,100,100,100,110};
        System.out.println("last index of 100 : "+lastindex(arr,0,100));
        lastindex01(arr,0,100,-1);
    }

    public static int lastindex(int[] arr,int idx,int data){
        if(idx==arr.length)
         return -1;

         int res=lastindex(arr,idx+1,data);
         if(res==-1&&arr[idx]==data)
          res=idx;
          return res;
    }

    public static void lastindex01(int[] arr,int idx,int data,int ans){
         if(idx==arr.length){
          System.out.println("last index of 100 : "+ans);    
         return ;
         }

        if(arr[idx]==data)
          ans=idx;
        lastindex01(arr,idx+1,data,ans);    
    }
}
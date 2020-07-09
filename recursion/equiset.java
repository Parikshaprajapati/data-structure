public class equiset{
    public static void main(String[] args){
        int[] arr={10,20,30,40,50,60,70,80};
        sets(arr,1,0,10," ","10 ");
    }

    public static void sets(int[] arr,int idx,int set1,int set2,String ans1,String ans2){
        if(set1==set2&&set1>0){
            System.out.print("set1 "+ans1+" "+" sum-> "+set1);
             System.out.println();
             System.out.println("set2 "+ans2+" "+" sum-> "+set2);
             System.out.println();
            return ;
        }

        if(idx<arr.length){
            sets(arr,idx+1,set1+arr[idx],set2,ans1+" "+String.valueOf(arr[idx]),ans2);
            sets(arr,idx+1,set1,set2+arr[idx],ans1,ans2+" "+String.valueOf(arr[idx]));
        }
    }
}
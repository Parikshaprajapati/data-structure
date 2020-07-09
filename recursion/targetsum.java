public class targetsum{
    public static void main(String[] args){
        int[] arr={10,20,30,40,50,60,70,80};
        taarget(arr,0,60," ");
    }

    public static void taarget(int[] arr,int idx,int target,String ans){
        if(target==0){
            System.out.print(ans+" ");
            return ;
        }

        if(idx<arr.length && target-arr[idx]>-1){
            taarget(arr,idx+1,target-arr[idx],ans+String.valueOf(arr[idx]));
            taarget(arr,idx+1,target,ans);
        }
    }
}
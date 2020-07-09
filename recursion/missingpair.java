public class missingpair{
    public static void main(String[] args){
        int[] arr={1,1,2,2,3,3,4,4,5,5,6,7,7};
       // missing(arr,0,arr.length-1);
        missing01(arr,0,arr.length-1);
    }

    public static void missing(int[] arr,int i,int f){
        if(i==f){
         if(i<arr.length-1&&arr[i]!=arr[i+1]&&arr[i-1]!=arr[i]){
              System.out.println("missing pair : "+arr[i]);
            }
         if(i==arr.length-1&&arr[i-1]!=arr[i])
              System.out.println("missing pair : "+arr[i]);
            return;
            }
        if(i+1==f){
            if(i>0&&arr[i]!=arr[f]&&arr[i-1]!=arr[i]){
              System.out.println("missing pair : "+arr[i]);
            }
            if(i==0&&arr[i]!=arr[f])
             System.out.println("missing pair : "+arr[i]);
           
            return;
        }

        int mid=(i+f)/2;
            missing(arr,i,mid);
            missing(arr,mid+1,f);
        
    }

    public static void missing01(int[] arr,int i,int f){
        if(i==f)return;
        int mid=i+f/2;
        if(mid==i||mid==f){
            if(mid%2!=0)
             System.out.println("missing pair : "+arr[mid+1]);
             else 
             System.out.println("missing pair : "+arr[mid]);
             return;
        }
        if(mid%2==0&&arr[mid]!=arr[mid+1])
        missing01(arr,i,mid-1);
        else if(mid%2!=0&&arr[mid]!=arr[mid-1])
        missing01(arr,i,mid-1);
        else
        missing01(arr,mid+1,f);
       
    }
}
public class coinchange{
    public static void main(String[] args){
        int[] arr={2,3,5,7};
        coinchangefunc(arr,0,10," ");
        System.out.println();
         coinchangefunc01(arr,0,10," ");
         Boolean[] visit={false,false,false,false};
           System.out.println();
         coinchangefunc02(arr,visit,10," ");
          System.out.println();
         coinchangefunc03(arr,10," ");
    }


//combination with repeatation
    public static void coinchangefunc(int[] arr,int idx,int target,String ans){
        if(target==0){
            System.out.print(ans+" ");
            return;
        }

        for(int i=idx;i<arr.length;i++){
            if(target-arr[i]>=0)
            coinchangefunc(arr,i,target-arr[i],ans+String.valueOf(arr[i]));
        }
    }

//combination without repeatation
     public static void coinchangefunc01(int[] arr,int idx,int target,String ans){
        if(target==0){
            System.out.print(ans+" ");
            return;
        }

        for(int i=idx;i<arr.length;i++){
            if(target-arr[i]>=0)
            coinchangefunc01(arr,i+1,target-arr[i],ans+String.valueOf(arr[i]));
        }
    }

//permutation without repeatation
    public static void coinchangefunc02(int[] arr,Boolean[] visit,int target,String ans){
        if(target==0){
            System.out.print(ans+" ");
            return; 
        }

        for(int i=0;i<arr.length;i++){
            if(visit[i]==false){
                 visit[i]=true;
                 coinchangefunc02(arr,visit,target-arr[i],ans+String.valueOf(arr[i]));
                 visit[i]=false;
            }
        }
    }

//permutatian with repeatation
     public static void coinchangefunc03(int[] arr,int target,String ans){
        if(target==0){
            System.out.print(ans+" ");
            return; 
        }

        for(int i=0;i<arr.length;i++)
        if(target-arr[i]>=0)
                 coinchangefunc03(arr,target-arr[i],ans+String.valueOf(arr[i]));   
    }
}
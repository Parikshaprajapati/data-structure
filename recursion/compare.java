import java.util.ArrayList;
public class compare{
    public static void main(String[] args){
        int[] arr={23,34,56,12,99,45,73,1};
       // ArrayList<Integer> arr01=new ArrayList<>(asList(23,34,56,12,99,45,73,1));
        System.out.println("maximum element : "+maximum(arr,0));
        System.out.println();
        System.out.println("minimum element : "+minimum(arr,0));
        System.out.println();
        System.out.println("find element (45): "+find(arr,0,45));
        System.out.println();
          maximum02(arr,0,Integer.MIN_VALUE);
        minimum02(arr,0,Integer.MAX_VALUE);
      //   System.out.println("maximum element : "+maximum01(arr01,0));
      //   System.out.println();
      //   System.out.println("minimum element : "+minimum01(arr01,0));
      //   System.out.println();
      //   System.out.println("find element (45): "+find01(arr01,0,45));
      //   System.out.println();
        
      
    }

//return type

    public static int maximum(int[] arr,int idx){
        if(idx==arr.length)
         return Integer.MIN_VALUE;
       int res=maximum(arr,idx+1);
       if(res<arr[idx])
       res=arr[idx];
       return res;
    }

     public static int minimum(int[] arr,int idx){
        if(idx==arr.length)
         return Integer.MAX_VALUE;
       int res=minimum(arr,idx+1);
       if(res>arr[idx])
       res=arr[idx];
       return res;
    }
     public static int find(int[] arr,int idx,int data){
        if(idx==arr.length){
         return -1;
        }
       int res=find(arr,idx+1,data);
       return arr[idx]==data?idx:res;
    }

// using arraylist

     public static Integer maximum01(ArrayList<Integer> arr01,int idx){
        if(idx==arr01.size())
         return Integer.MIN_VALUE;
       int res=maximum01(arr01,idx+1);
       if(res<arr01.get(idx))
       res=arr01.get(idx);
       return res;
    }

     public static Integer minimum01(ArrayList<Integer> arr01,int idx){
        if(idx==arr01.size())
         return Integer.MAX_VALUE;
       int res=minimum01(arr01,idx+1);
       if(res>arr01.get(idx))
       res=arr01.get(idx);
       return res;
    }
     public static int find01(ArrayList<Integer> arr01,int idx,int data){
        if(idx==arr01.size()){
         return -1;
        }
       int res=find01(arr01,idx+1,data);
       return arr01.get(idx)==data?idx:res;
    }

// void type
     
     public static void maximum02(int[] arr,int idx,int max){
        if(idx==arr.length){
        System.out.println(max);
         return ;
     }
      if(max<arr[idx])
       max=arr[idx];
       maximum02(arr,idx+1,max);
      
    }

     public static void minimum02(int[] arr,int idx,int min){
        if(idx==arr.length){
          System.out.println(min);  
         return ;
        }
        if(min>arr[idx])
       min=arr[idx];
       minimum02(arr,idx+1,min);      
      }

    
}
public class printno{
     public static void main(String[] args){
        System.out.println("increasing order:");
        increasingorder(0,10);
        System.out.println();
        System.out.println("decreasing order:");
        decreasingorder(0,10);
        System.out.println();
        System.out.println("increase-decrease order:");
        indecreasingorder(0,10);
        System.out.println();
        System.out.println("even-odd order:");
        evenodd(0,10);
        System.out.println();
        System.out.println("powerbetter: "+powerbetter(2,10));
        System.out.println();
        System.out.println("fibonacci sequence: "+fibonacci(5));
        


    }
     public static void increasingorder(int a,int b){
         if(a>b)return;
         System.out.print(a+" ");
         increasingorder(a+1,b);
     }
     public static void decreasingorder(int a,int b){
         if(a>b)return;
         decreasingorder(a+1,b);
         System.out.print(a+" ");
     }
     public static void indecreasingorder(int a,int b){
         if(a==b){
             System.out.print(a+" ");
             return;
         }
         System.out.print(a+" ");
         indecreasingorder(a+1,b);
         System.out.print(a+" ");
     }
     public static void evenodd(int a,int b){
         if(a>b)return;
         if(a%2==0)
          System.out.print(a+" ");
          evenodd(a+1,b);
          if(a%2!=0)
          System.out.print(a+" "); 
     }
     public static int powerbetter(int a,int b){
         if(b==0)return 1;
        
         int reans=powerbetter(a,b/2);
         reans*=reans;
         if(b%2!=0)
         reans=reans*a;
         return reans;
     }
     public static int fibonacci(int n){
         if(n==0||n==1){
            return n;
         }
         return fibonacci(n-2)+fibonacci(n-1);
     }

}
import java.util.Scanner;
public class codegladiator{
  public static void main(String[] args){
      Scanner scn=new Scanner(System.in);
     int n=scn.nextInt();
    int[] req=new int[n];
    int[] giv=new int[n];
    for(int i=0;i<n;i++)
    {
        req[i]=scn.nextInt();
    }
    for(int i=0;i<n;i++)
    {
        giv[i]=scn.nextInt();
    } 

    System.out.println(target(req,giv,n));
  }

 public static int target(int[] req,int[] giv,int n){
    for(int i=0;i<n;i++){
        if(giv[i]==0)
        return 0;
    }
    int count=0;
    boolean pass=true;
    for(int i=0;i<n;i++){
      if(giv[i]-req[i]>=0){
      giv[i]=giv[i]-req[i];
      }
       else{
         pass=false;
         break;
       }
    }
      if(pass==true)
     count=1+target(req,giv,n); 
        return count;
}

}


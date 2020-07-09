public class powerpuff{
  public static void main(String[] args){
      System.out.println(making(2,3,5,15,27,40));
  }

  public static int making(int a,int b,int c,int A,int B,int C){
      if(A==0||B==0||C==0)
      return 0;

      int count=0;
      if(A-a>=0&&B-b>=0&&C-c>=0)
       count=1+making(a,b,c,A-a,B-b,C-c);

      return count;
  }
}
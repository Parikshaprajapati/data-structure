import java.util.Scanner;
public class evenodd{
    public static void main(String[] args){
     Scanner scn=new Scanner(System.in);
        int num=scn.nextInt();
        System.out.println(evenorodd(num));

    }

    public static String evenorodd(int num){
        int mask=1;
        if(num&mask==0)
        return "even";
        else
        return "odd";
    }
} 
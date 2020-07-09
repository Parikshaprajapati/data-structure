public class encoding{
    public static void main(String[] args){
      char[] alpha={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
      encode(alpha,110066," ");
    }

    public static void encode(char[] alpha,int code,String ans){
        if(code==0){
            System.out.print(ans+" ");
            return;
        }
        if(code%10==0)
        encode(alpha,code/10,ans);
        else
        encode(alpha,code/10,alpha[code%10-1]+ans);
        if(code%100>=10 && code%100<=26)
        encode(alpha,code/100,alpha[code%100-1]+ans);
    }


}
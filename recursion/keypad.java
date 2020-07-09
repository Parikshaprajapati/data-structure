public class keypad{
    public static void main(String[] args){
        String[] codess={"+","abc","def","ghi","jkl","mno","pqrs","tuv","wx","yz","*","#"};
        String num="235";
        encoding(codess,num," ");
    }
    
   public static void encoding(String[] codess,String num,String ans){
       if(num.length()==0){
           System.out.print(ans+" ");
           return;
       }

       char ch=num.charAt(0);
       num=num.substring(1);
       String str=codess[ch-'0'];
       for(int i=0;i<str.length();i++){
           encoding(codess,num,ans+str.charAt(i));
       }
   }
}
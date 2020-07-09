import java.util.ArrayList;
public class subsequence01{
    public static void main(String[] args){
        String str="123";
        subseq(str," ");
        ArrayList<String> ans=subseq01(str);
        System.out.println();
        System.out.println(ans);
         ArrayList<String> ans01=dash(str);
         System.out.println(ans01);
         System.out.println();
         dash01(str.substring(1),""+str.charAt(0));

    }

    public static void subseq(String str,String ans){
        if(str.length()==0){
          System.out.print("{"+ans+" }"+"  ");
          return;
        }
        
        char ch=str.charAt(0);
        String restr=str.substring(1);
        subseq(restr,ans+ch);
        subseq(restr,ans);
        
            }

    public static ArrayList<String> subseq01(String str){
        if(str.length()==0){
            ArrayList<String> base=new ArrayList<>();
            base.add(" ");
            return base;
        }
         
        char ch=str.charAt(0);
        String restr=str.substring(1);
        ArrayList<String> recans= subseq01(restr);
        ArrayList<String> myans=new ArrayList<>();

        for(String s:recans){
            myans.add(ch+s);
            myans.add(s);
                  }
        
        return myans;
    }

     public static ArrayList<String> dash(String str){
        if(str.length()==1){
            ArrayList<String> base=new ArrayList<>();
            char ch=str.charAt(0);
            base.add(ch+" ");
            return base;
        }
         
        char ch=str.charAt(0);
        String restr=str.substring(1);
        ArrayList<String> recans= dash(restr);
        ArrayList<String> myans=new ArrayList<>();

        for(String s:recans){
            myans.add(ch+s);
            myans.add(ch+"_"+s);
                  }
        
        return myans;
    }

 public static void dash01(String str,String ans){
        if(str.length()==0){
           System.out.print("{"+ans+"}"+"  ");
            return ;
        }
         
        char ch=str.charAt(0);
        String restr=str.substring(1);
        dash01(restr,ans+ch);
        dash01(restr,ans+"_"+ch);
    }

}
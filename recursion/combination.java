import java.util.ArrayList;
public class combination{
    public static void main(String[] args){
        String str="abc";
        ArrayList<String> ans=comb(str);
          System.out.println(ans);
          System.out.println();
          comb01(str," ");
          
    }

//return type 

    public static ArrayList<String> comb(String str){
        if(str.length()==0){
            ArrayList<String> base=new ArrayList<>();
            base.add(" ");
            return base;
        }
         
        char ch=str.charAt(0);
        String restr=str.substring(1);
        ArrayList<String> recans= comb(restr);
        ArrayList<String> myans=new ArrayList<>();

        for(String s:recans){
            for(int i=0;i<s.length();i++){
             String first=s.substring(0,i); 
             String last=s.substring(i);  
            myans.add(first+ch+last);
            }
                  }
        
        return myans;
    }

//void type 

    public static void comb01(String str,String ans){
        if(str.length()==0){
            System.out.print(ans+"");
            return ;
        }
        int n=ans.length();
       char ch=str.charAt(0);
       for(int i=0;i<n;i++){
           String first=ans.substring(0,i); 
           String last=ans.substring(i);  
            comb01(str.substring(1),first+ch+last); 
       }
    }
}
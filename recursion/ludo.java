import java.util.ArrayList;
public class ludo{
    public static void main(String[] args){
        ArrayList<String> ans=findtarget(10);
        System.out.println(ans);
        System.out.println();
        findtarget01(10," ");
    }

    public static ArrayList<String> findtarget(int target){
        if(target==0){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myans=new ArrayList<>();
        for(int i=1;i<=6&&target-i>=0;i++){
         ArrayList<String> recans=findtarget(target-i);
         for(String s:recans)
         myans.add(String.valueOf(i)+s);
        }
        return myans;
    }

     public static void findtarget01(int target,String ans){
        if(target==0){
            System.out.print(ans+" ");
            return ;
        }
        for(int i=1;i<=6&&target-i>=0;i++)
        findtarget01(target-i,ans+String.valueOf(i));
    }
}
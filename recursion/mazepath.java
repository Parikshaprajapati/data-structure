import java.util.ArrayList;
public class mazepath{
    public static void main(String[] args){
        ArrayList<String> ans=findpath(0,0,2,2);
        System.out.println(ans);
         ArrayList<String> ans01=findpath01(0,0,2,2);
        System.out.println(ans01);
         ArrayList<String> ans02=jumpmaze(0,0,2,2);
        System.out.println(ans02);
        System.out.println();
        findpath02(0,0,2,2," ");
        System.out.println();
        findpath03(0,0,2,2," ");
         System.out.println();
        jumpmaze01(0,0,2,2," ");

    }

    public static ArrayList<String> findpath(int sr,int sc,int r,int c){
        if(sr==r&&sc==c){
            ArrayList<String> base=new ArrayList<>();
            base.add(" ");
            return base;
        }

        ArrayList<String> myans=new ArrayList<>();
        if(sr+1<=r){
            ArrayList<String> reans=findpath(sr+1,sc,r,c);
            for(String s:reans)
            myans.add('H'+s);
        }

         if(sc+1<=c){
            ArrayList<String> recans=findpath(sr,sc+1,r,c);
            for(String s:recans)
            myans.add('V'+s);
        }
        return myans;
    }

     public static ArrayList<String> findpath01(int sr,int sc,int r,int c){
        if(sr==r&&sc==c){
            ArrayList<String> base=new ArrayList<>();
            base.add(" ");
            return base;
        }

        ArrayList<String> myans=new ArrayList<>();
        if(sr+1<=r){
            ArrayList<String> reans=findpath01(sr+1,sc,r,c);
            for(String s:reans)
            myans.add('H'+s);
        }

         if(sc+1<=c){
            ArrayList<String> recans=findpath01(sr,sc+1,r,c);
            for(String s:recans)
            myans.add('V'+s);
        }

        
         if(sr+1<=r&&sc+1<=c){
            ArrayList<String> reecans=findpath01(sr+1,sc+1,r,c);
            for(String s:reecans)
            myans.add('D'+s);
        }
        return myans;
    }

     public static ArrayList<String> jumpmaze(int sr,int sc,int r,int c){
        if(sr==r&&sc==c){
            ArrayList<String> base=new ArrayList<>();
            base.add(" ");
            return base;
        }

        ArrayList<String> myans=new ArrayList<>();
        for(int i=1;sr+i<=r;i++){
            ArrayList<String> reans=jumpmaze(sr+i,sc,r,c);
            for(String s:reans)
            myans.add('H'+String.valueOf(i)+s);
        }

         for(int j=1;sc+j<=c;j++){
            ArrayList<String> recans=jumpmaze(sr,sc+j,r,c);
            for(String s:recans)
            myans.add('V'+String.valueOf(j)+s);
        }

        
         for(int i=1;sr+i<=r&&sc+i<=c;i++){
            ArrayList<String> reecans=jumpmaze(sr+i,sc+i,r,c);
            for(String s:reecans)
            myans.add('D'+String.valueOf(i)+s);
        }
        return myans;
    }

    //void type

    public static void findpath02(int sr,int sc,int r,int c,String ans){
        if(sr==r&&sc==c){
            System.out.print(ans+" ");
            return ;
        }

        if(sr+1<=r){
            findpath02(sr+1,sc,r,c,ans+'H');
        }

         if(sc+1<=c){
           findpath02(sr,sc+1,r,c,ans+'V');
        }
    }

     public static void findpath03(int sr,int sc,int r,int c,String ans){
        if(sr==r&&sc==c){
            System.out.print(ans+" ");
            return ;
        }

        if(sr+1<=r){
            findpath03(sr+1,sc,r,c,ans+'H');
        }

         if(sc+1<=c){
           findpath03(sr,sc+1,r,c,ans+'V');
        }

         if(sc+1<=c&&sr+1<=r){
           findpath03(sr+1,sc+1,r,c,ans+'D');
        }
    }

    public static void jumpmaze01(int sr,int sc,int r,int c,String ans){
        if(sr==r&&sc==c){
             System.out.print(ans+" ");
            return;
        }

        for(int i=1;sr+i<=r;i++)
            jumpmaze01(sr+i,sc,r,c,ans+'H'+String.valueOf(i));
           
        for(int j=1;sc+j<=c;j++)
            jumpmaze01(sr,sc+j,r,c,ans+'V'+String.valueOf(j));
          
        for(int i=1;sr+i<=r&&sc+i<=c;i++)
            jumpmaze01(sr+i,sc+i,r,c,ans+'D'+String.valueOf(i)); 
    }

}
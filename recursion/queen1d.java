public class queen1d{
    public static void main(String[] args){
        placequeen(3,0,4," ");
        Boolean[] visit={false,false,false,false,false};
        System.out.println();
        System.out.println(placequeen01(visit,3,5," "));
    }


//combination
    public static void placequeen(int queen,int i,int f,String ans){
        if(queen==0){
            System.out.print(ans+" ");
            return;
        }

       if(i<=f){
        placequeen(queen-1,i+1,f,ans+"b"+String.valueOf(i));
        placequeen(queen,i+1,f,ans);
       }
    }

//permutation
 public static int  placequeen01(Boolean[] visit,int queen,int box,String ans){
        if(queen==0){
            System.out.print(ans+" ");
            return 1;
        }
       int count=0;
       for(int i=0;i<box;i++){
       if(visit[i]==false){
       visit[i]=true;
       count+= placequeen01(visit,queen-1,box,ans+"q"+String.valueOf(queen)+"b"+String.valueOf(i));
       visit[i]=false;
       }
    }
    return count;
 }
}
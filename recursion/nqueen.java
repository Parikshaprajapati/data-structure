public class nqueen{
    public static void main(String[] args){
         int[][] isvisit=new int[4][4];
        System.out.println(locatequeen(0,0,4,4,isvisit," "));
    }

public static Boolean isvalidspot(int sr,int sc,int size){
    if(sr<0||sc<0||sr>=size||sc>=size)
    return false;
    return true;
}

public static Boolean isqueensafe(int sr,int sc,int size,int[][] isplaced){
      int[][] move={{0,-1},{-1,-1},{1,-1}};

        for(int jump=1;jump<size;jump++){
        for(int i=0;i<move.length;i++){
                int x=sr+jump*move[i][0];
                int y=sc+jump*move[i][1];
                if(x<0||y<0||x>=size||y>=size)
                continue;
             if(isplaced[x][y]==1)
               return false;
            }
        }
        return true;
}

 public static int locatequeen(int sr,int sc,int size,int queen,int[][] isplaced,String ans){
        if(queen==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        if(isvalidspot(sr,sc,size)){
            if(isqueensafe(sr,sc,size,isplaced)){
                isplaced[sr][sc]=1;
                count+=locatequeen(0,sc+1,size,queen-1,isplaced,ans+"("+String.valueOf(sr)+","+String.valueOf(sc)+") ");
                isplaced[sr][sc]=0;
            }
                count+=locatequeen(sr+1,sc,size,queen,isplaced,ans);
        }
         
       return count;
    }
}
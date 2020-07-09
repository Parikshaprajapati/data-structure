public class sudoku{
    public static void main(String[] args){
        int[][] game={{5,3,0,0,7,0,0,0,0},
                      {6,0,0,1,9,5,0,0,0},
                      {0,9,8,0,0,0,0,6,0},
                      {8,0,0,0,6,0,0,0,3},
                      {4,0,0,8,0,3,0,0,1},
                      {7,0,0,0,2,0,0,0,6},
                      {0,6,0,0,0,0,2,8,0},
                      {0,0,0,4,1,9,0,0,5},
                      {0,0,0,0,8,0,0,7,9}};
        System.out.println(fillsudoku(0,game));
    }

    public static Boolean safevalue(int r,int c,int val,int[][] game){

        for(int i=0;i<game.length;i++){
            if(game[i][c]==val)
             return false;

            if(game[r][i]==val)
             return false;
        }

        int nr=(r/3)*3;
        int nc=(c/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(game[nr+i][nc+j]==val)
                 return false;
            }
        }

        return true;
    }

    public static void display(int[][] game){
        for(int i=0;i<game.length;i++){
            for(int j=0;j<game.length;j++){
                System.out.print(game[i][j]+" ");
            }
            System.out.println();
        }
         System.out.println();
          System.out.println();
    }

    public static int fillsudoku(int box,int[][] game){
        if(box==81){
            display(game);
            return 1;
        }

       int count=0;
       int r=box/9;
       int c=box%9;
            if(game[r][c]==0 ){
                for(int i=1;i<=9;i++){
                    if(safevalue(r,c,i,game)==true){
               game[r][c]=i;
               count+=fillsudoku(box+1,game);
                game[r][c]=0;
                    }
                }
            }
            else{
               count+=fillsudoku(box+1,game);
            }

        return count;
    }
}   
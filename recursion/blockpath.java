public class blockpath{
    public static void main(String[] args){
        int[][] visited={{0,0,0},
                         {0,1,0},
                         {1,0,0}};
        System.out.println(floodfill(0,0,2,2,visited," "));
       
    }

    public static int floodfill(int sr,int sc,int r,int c,int[][] visited,String ans){
        if(sr==r&&sc==c){
            System.out.print(ans+" ");
            return 0;
        }

        visited[sr][sc]=1;
        int[][] move={{0,1},{1,0},{0,-1},{-1,0}};
        char[] dir={'R','D','L','U'};
        int max=0;

        for(int i=0;i<dir.length;i++){
            int x=sr+move[i][0];
            int y=sc+move[i][1];
                if(isvalid(x,y,r,c,visited)!=true){
                    int reans=floodfill(x,y,r,c,visited,ans+dir[i]);
                    if(reans>max)
                    max=reans;
                }
        }

        visited[sr][sc]=0;
        return max+1;
    }

    public static Boolean isvalid(int x,int y,int r,int c,int[][] visited){
        if(x<0||y<0||x>r||y>c||visited[x][y]==1)
        return true;
        else
        return false;
    }
}
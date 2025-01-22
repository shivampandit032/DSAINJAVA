package Backtracking;

import java.util.ArrayList;

public class Nqueen2 {
    public static void main(String[] args) {
        int n = 4 ;
        int[][] board = new int[n][n];

        ArrayList<int[][]> result = new ArrayList<>();

        nqueen(board, 0 , n , result);
        display(result , n );
    }
    static void nqueen(int[][] board , int r , int n , ArrayList<int[][]> result){
        if(r >= n){
            result.add(board);

            return ;
        }
        for(int c = 0 ;  c < n ; c++){
            if(isSafe(board,r , c , n)){

                board[r][c] = 1;

                nqueen(board , r+1 , n , result);

                board[r][c] = 0 ;
            }
        }
    }
    static boolean isSafe(int[][] board, int r , int c , int n){
        for(int i = 0; i< r ; i++){
            if(board[i][c] == 1){
                return false ;
            }
        }

//        int Lri = r-1;
//        int Lci = c-1;
//
//        while(Lri >=0 && Lci >= 0 ){
//            if(board[Lri][Lci] == 1){
//
//                return false ;
//            }
//            Lri--;
//            Lci--;
//
//        }
//
//        int Rri = r-1;
//        int Rci = c+1;
//
//        while(Rri >= 0 && Rci < n){
//            if(board[Rri][Rci] == 1){
//                return false ;
//            }
//            Rri--;
//            Rci++;
//        }
//
//        return true;

        int maxLeft = Math.min(r , c);

        int Lri = r-1;
        int Lci = c-1;

        for(int i=1 ; i<= maxLeft ; i++){
            if(board[Lri][Lci] == 1){
                return false;
            }
            Lri--;
            Lci--;
        }

        int maxRight = Math.min(r , c);
        int Rri = r-1;
        int Rci = c+1 ;
        for(int i = 1 ; i<= maxRight ;i++){
            if (board[Rri][Rci] == 1) {
                return false ;
            }
            Rri--;
            Rci++;
        }

        return true;
    }

    static void display(ArrayList<int[][]> board , int n){

        for(int[][] a : board){
            for(int i =0 ; i<n ;i++){
                for(int j=0;j<n ; j++){
                    if(a[i][j] == 1){
                        System.out.print(" Q ");
                    }
                    else{
                        System.out.print(" X ");
                    }

                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }
    }
}

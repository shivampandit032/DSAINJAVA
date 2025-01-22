package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Nqueen {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];

        int n = 4 ;

        ArrayList<boolean[][]> result = new ArrayList<>();


        nqueen(board , 0 , n , result);

        display(result,n);
    }
    static void nqueen(boolean[][] board , int r , int n,ArrayList<boolean[][]> result ){

        if(r >= n){
            result.add(board);

            return ;
        }
        for(int c = 0 ; c < n ; c++){

            if(isSafe(board , r,c , n)){

                board[r][c] = true ;

                nqueen(board , r+1 , n , result);

                board[r][c] = false ;
            }
        }

    }
    static boolean isSafe(boolean[][] board , int r , int c , int n){
        for(int i=r-1 ; i>=0 ; i--){
            if(board[i][c]){
                return false ;
            }
        }
//        int Lri = r-1;
//        int Lci = c-1;
//
//        while(Lri>=0 && Lci >=0){
//            if(board[Lri][Lci]){
//                return false;
//            }
//            Lri--;
//            Lci--;
//        }
//
//        int Rri = r-1;
//        int Rci = c+1 ;
//
//        while(Rri >=0 && Rci <= n-1){
//            if(board[Rri][Rci]){
//                return false ;
//            }
//            Rri--;
//            Rci++;
//        }
//        return true ;

        int maxLeft = Math.max(r , c);
        int Lri = r-1;
        int Lci = c-1 ;

        for(int i=1;i<= maxLeft; i++){
            return false;
        }
        return true;
    }

    static void display(ArrayList<boolean[][]> result ,int n){
            for(boolean[][] a: result){
                for(int p = 0 ;p<n ;p++){
                    for(int q =0 ; q<n ;q++){
                        if(a[p][q]){
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

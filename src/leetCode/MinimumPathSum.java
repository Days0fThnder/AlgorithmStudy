package leetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        Queue<String> pQueue = new LinkedList<>();

        pQueue.add("0,0,"+grid[0][0]);
        Set<String> visited = new HashSet<>();

        int resVal = grid[0][0];
        int tRow = grid.length-1;
        int tCol = grid[tRow].length-1;


        while(!pQueue.isEmpty()){
            String cellInfo = pQueue.remove();
            int row = getRow(cellInfo);
            int col = getCol(cellInfo);
            int val = getVal(cellInfo);


            int newRow = row < grid.length-1 ? row+1 : row;
            int newCol = col < grid[tRow].length-1 ? col+1 : col;
            int downVal = grid[newRow][col];
            int rightVal = grid[row][newCol];

            resVal = Math.min(resVal, Math.min(downVal, rightVal))+val;

            if(tRow == row && tCol == col){
                return resVal;
            }

            if(!visited.contains(newRow+","+col)){
                downVal += val;
                pQueue.add(newRow+","+col+"," +downVal);
                visited.add(newRow+","+col);
            }
            if(!visited.contains(row+","+newCol)){
                rightVal += val;
                pQueue.add(row+","+newCol+"," +rightVal);
                visited.add(row+","+newCol);
            }

        }

        return -1;

    }

    private int getRow(String cellInfo){

        return Integer.parseInt(cellInfo.substring(0,1));
    }

    private int getCol(String cellInfo){

        return Integer.parseInt(cellInfo.substring(2,3));
    }

    private int getVal(String cellInfo){

        return Integer.parseInt(cellInfo.substring(4,5));
    }

    public static void main(String [] args){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        minimumPathSum.minPathSum(grid);
    }
}

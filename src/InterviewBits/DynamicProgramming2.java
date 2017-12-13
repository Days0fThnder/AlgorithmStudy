package InterviewBits;

import java.util.ArrayList;

public class DynamicProgramming2 {

    int maxSum = 0;
    public int adjacent(ArrayList<ArrayList<Integer>> grid){
        int rowIn = 1;

        if(grid.get(0).size() < 4){
            for (int row = 0; row < grid.size() ; row++) {
                for (int col = 0; col < grid.get(row).size(); col++) {
                   if( grid.get(row).get(col) > maxSum){
                       maxSum = grid.get(row).get(col);
                   }
                }
            }
        }else {
            for (int row = 0; row < grid.size(); row++) {
                for (int col = 0; col < grid.get(row).size(); col++) {
                    maxSum = getMaxSum(grid, row, col, rowIn);
                }
            }
        }

        return maxSum;
    }

    private int getMaxSum(ArrayList<ArrayList<Integer>> grid, int row, int col, int rowIn) {

        int cVal = grid.get(row).get(col);
        if (row == 1){
            rowIn = -1;
        }
        if(col == 0){
            for (int i = 2; i < grid.get(row).size(); i++) {
                if (cVal + grid.get(row).get(i) > maxSum){
                    maxSum = cVal+grid.get(row).get(i);
                }

                if (cVal + grid.get(row+rowIn).get(i) > maxSum){
                    maxSum =  cVal+grid.get(row+rowIn).get(i);
                }
            }
        }else{
            for (int i = 0; i < grid.get(row).size(); i++) {
                if(i < col -2 || i >= col +2){
                    if (cVal +grid.get(row).get(i) > maxSum){
                        maxSum = cVal+grid.get(row).get(i);
                    }
                    if (cVal + grid.get(row+rowIn).get(i) > maxSum){
                        maxSum = cVal+grid.get(row+rowIn).get(i);
                    }
                }
            }
        }

        return maxSum;
    }

    public static void main(String [] arg){
        int [][] grid = {{16, 5, 54, 55, 36, 82, 61, 77, 66, 61},{31, 30, 36, 70, 9, 37, 1, 11, 68, 14}};
        //int [][] grid = {{2, 68},{13, 4}};
        ArrayList<ArrayList<Integer>> gridList = new ArrayList<>();
        gridList.add(new ArrayList<>());
        gridList.add(new ArrayList<>());
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length ; j++) {
                gridList.get(i).add(grid[i][j]);
            }
        }
        DynamicProgramming2 dp2 = new DynamicProgramming2();
        System.out.println(dp2.adjacent(gridList));
    }
}

package Sandbox;

import java.util.*;
import java.util.List;


/**
 * Created by j_rus on 1/21/2017.
 */

public class Sandbox3 {


    class Coor{
        int row;
        int col;

        public Coor(int row, int col){
            this.row = row;
            this.col = col;
        }

        public int getRow(){
            return row;
        }

        public void setRow(int row){
            this.row = row;
        }

        public int getCol(){
            return col;
        }

        public void setCol(int col){
            this.col = col;
        }
    }
    private int [][] pond = new int[][] {
                                {0,2,1,0},
                                {0,1,0,1},
                                {1,1,0,1},
                                {0,1,0,1}
                            };

    int counter = 0;

    public List pondSize (int map[][]){
        Set<Coor> visited = new HashSet<>();
        List<Integer> results = new ArrayList<>();

        for(int row = 0; row < map.length; row++){
            for(int col = 0; col < map[row].length; col++){
               if(map[row][col] == 0 && !visited.contains(new Coor(row, col))){
                   results.add(findPond(map, row, col, visited));
                   counter = 0;
               }
            }
        }
        return results;
    }

    private int findPond(int map[][], int row, int col, Set visited){
        if((row >= 0 && row < map.length) &&
                (col >= 0 && col < map[row].length)){
            if(map[row][col] == 0 && !visited.contains(new Coor(row, col))){
                visited.add(new Coor(row, col));
                findPond(map, row+1, col, visited);
                findPond(map, row-1, col, visited);
                findPond(map, row, col+1, visited);
                findPond(map, row, col-1, visited);
                findPond(map, row+1, col+1, visited);
                findPond(map, row-1, col-1, visited);
                findPond(map, row-1, col+1, visited);
                findPond(map, row+1, col-1, visited);
                return counter++;
            }else{
                return counter;
            }
        }else{
            return counter;
        }
    }

    public static void main(String [] arg){
        Sandbox3 sb3 = new Sandbox3();
        List<Integer> sizes = sb3.pondSize(sb3.pond);
        for(Integer num : sizes){
            System.out.print(num);
        }
    }
}

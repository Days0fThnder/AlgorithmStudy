package langstonsAnt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by j_rus on 3/11/2017.
 */
public class Grid {

    private int size = 0;
    private int rowSize = 0;
    private int colSize = 0;
    private Random rand = new Random();
    private boolean color = false;
    private String white = "white";
    private String black = "black";
    private List<List<GridNode>> grid = new ArrayList<>();



    public void addRow(){
        List<GridNode> row = new ArrayList<>();
        GridNode gn = new GridNode();
        row.add(gn);

        createRow(row, false);
        grid.add(row);
        rowSize++;
        colSize = row.size();
        size = rowSize * row.size();
    }

    public void negAddRow(List<GridNode> row){
        //grid.add(row);
        for (int i = grid.size()-1; i >= 0 ; i--) {
            grid.add(i+1,grid.get(i));
        }

        ArrayList<GridNode> arr = new ArrayList<>();
        createRow(arr, true);
        grid.add(0,arr);
        rowSize++;
        size = rowSize * row.size();
    }

    public void addCol(){
        for (List<GridNode> row: grid) {
            color = rand.nextBoolean();
            GridNode gn = new GridNode();
            gn.setWest(row.get(row.size()-1));
            if(color){
                gn.setColor(white);
                row.add(row.size(), gn);
            }else{
                gn.setColor(black);
                row.add(row.size(), gn);
            }
            //row;
        }
        colSize = grid.get(0).size();
        size = rowSize * grid.get(0).size();
    }

    public void NegAddCol(){
        for (List<GridNode> row: grid) {
            row.add(row.size(), new GridNode());
            for (int i = row.size()-2; i >=0; i--) {
                if(i == row.size() -2){
                    row.get(i).setEast(null);
                }
                row.add(i-1, row.get(i));
            }
        }
    }

    private void createRow(List<GridNode> row, boolean top) {

        for (GridNode gn: row) {
            color = rand.nextBoolean();
            if (color){
                gn.setColor(white);
            }else{
                gn.setColor(black);
            }
        }

        for (int i = 0; i < row.size()-2 ; i++) {
            row.get(i).setEast(row.get(i+1));
        }

        if (grid.size() != 0){
            int newRowIndx = 0;
            if(!top) {
                for (GridNode gn : grid.get(grid.size() - 1)) {
                    gn.setSouth(row.get(newRowIndx));
                    row.get(newRowIndx).setNorth(gn);
                    newRowIndx++;
                }
            }else{
                for (GridNode gn : grid.get(1)) {
                    gn.setNorth(row.get(newRowIndx));
                    row.get(newRowIndx).setSouth(gn);
                    newRowIndx++;
                }
            }
        }
    }

    public List<List<GridNode>> getGrid() {
        return grid;
    }
    public int getSize() {
        return size;
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColSize() {
        return colSize;
    }
}

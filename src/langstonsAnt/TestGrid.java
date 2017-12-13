package langstonsAnt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j_rus on 3/11/2017.
 */
public class TestGrid {

    public static void main(String [] arg){
        Grid gd = new Grid();
        for (int i = 0; i <2 ; i++) {
            gd.addRow();
        }

        for (List<GridNode> row:gd.getGrid()) {
            for (GridNode gn: row) {
                System.out.println(gn.getColor());
            }
        }

    }
}

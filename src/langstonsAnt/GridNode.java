package langstonsAnt;

/**
 * Created by j_rus on 3/11/2017.
 */
public class GridNode {

    private GridNode north;
    private GridNode south;
    private GridNode east;
    private GridNode west;
    private String color;
    private String direction;

    public GridNode() {
    }

    public GridNode(String color) {
        this.color = color;
    }

    public GridNode(GridNode north, GridNode south, GridNode east, GridNode west, String color) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.color = color;
    }

    public GridNode getNorth() {
        return north;
    }

    public void setNorth(GridNode north) {
        this.north = north;
    }

    public GridNode getSouth() {
        return south;
    }

    public void setSouth(GridNode south) {
        this.south = south;
    }

    public GridNode getEast() {
        return east;
    }

    public void setEast(GridNode east) {
        this.east = east;
    }

    public GridNode getWest() {
        return west;
    }

    public void setWest(GridNode west) {
        this.west = west;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

}

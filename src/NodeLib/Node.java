package NodeLib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j_rus on 4/30/2016.
 */
public class Node {

    private int data;

    private Node left;
    private Node right;
    private Node adj;
    private List <Node> adjList = new ArrayList<>();
    private boolean visited = false;

    public Node(int data){
        this.data = data;
    }
    public Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(int data, Node adj){
        this.data = data;
        this.adj = adj;
        this.left = null;
        this.right = null;
    }

    public List<Node> getAdjList() {
        return adjList;
    }

    public void setAdjList(List<Node> adjList) {
        this.adjList = adjList;
    }

    public Node getAdj() {
        return adj;
    }

    public void setAdj(Node adj) {
        this.adj = adj;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getData() {
        return data;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String toString(){
        return ""+data+"";
    }

}

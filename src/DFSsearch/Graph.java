package DFSsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by j_rus on 4/15/2016.
 */
class Neighbor{
    public int vertexNum;
    public Neighbor next;
    public Neighbor(int vnum, Neighbor nbr){
        this.vertexNum = vnum;
        next = nbr;
    }
}
class Vertex {
    String name;
    Neighbor adj;
    Vertex(String name, Neighbor neighbors ){
        this.name = name;
        this.adj = neighbors;
    }
}

public class Graph{
    Vertex[] adjList;
    public Graph(String file) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(file));

        String graphType = sc.next();
        boolean undireceted=true;
        if(graphType.equals("directed")){
            undireceted = false;
        }

        adjList = new Vertex[sc.nextInt()];

        for (int v = 0; v < adjList.length; v++){
            adjList[v] = new Vertex(sc.next(), null);
        }

        while (sc.hasNext()){

            int v1 = indexForName(sc.next());
            int v2 = indexForName(sc.next());

            adjList[v1].adj = new Neighbor(v2, adjList[v1].adj);
            if (undireceted){
                adjList[v2].adj = new Neighbor(v1, adjList[v2].adj);
            }
        }
    }

    int indexForName(String name){
        for (int v=0; v < adjList.length; v++){
            if (adjList[v].name.equals(name)){
                return v;
            }
        }
        return -1;
    }

    // recursive dfs
    private void dfs(int v, boolean[] visited){
        visited[v] = true;
        System.out.println("Visiting " + adjList[v].name);
        for (Neighbor nbr=adjList[v].adj; nbr != null; nbr=nbr.next){
            if (!visited[nbr.vertexNum]){
                System.out.println("\n" + adjList[v].name + "--" + adjList[nbr.vertexNum].name);
                dfs(nbr.vertexNum, visited);
            }
        }
    }

    public void dfs(){
        boolean[] visited = new boolean[adjList.length];
        for (int v=0; v < visited.length; v++) {
            if (!visited[v]){
                System.out.println("\nSTARTING AT " + adjList[v].name);
                dfs(v, visited);
            }
        }
    }
    public void print() {
        System.out.println();
        for (int v=0; v < adjList.length; v++) {
            System.out.print(adjList[v].name);
            for (Neighbor nbr=adjList[v].adj; nbr != null;nbr=nbr.next) {
                System.out.print(" --> " + adjList[nbr.vertexNum].name);
            }
            System.out.println("\n");
        }
    }
    /*
    * @param args
    */
    public static void main(String[] args) throws IOException {

    }

}

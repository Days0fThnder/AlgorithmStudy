package Sandbox;

import NodeLib.GraphEdge;

import java.util.*;

/**
 * Created by j_rus on 5/1/2017.
 */
public class Sandbox13 {

    static class GraphNode{
        private int value;

        public GraphNode(int value){
            this.value = value;
        }
    }

    static class GraphEdge{
        int source;
        int dest;

        public GraphEdge(int source, int dest){
            this.source = source;
            this.dest = dest;
        }
    }

    public static void main(String [] arg){
        Set<Integer> nodeValues = new HashSet<>();
        Set<Integer> edgeNodes = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        for (int i = 0; i <queries ; i++) {
            int numOfNodes = sc.nextInt();
            int numOfedges = sc.nextInt();
            for (int j = 1; j <= numOfNodes ; j++) {
                nodeValues.add(j);
            }
            for (int j = 0; j < numOfedges ; j++){
                int firstInt = sc.nextInt();
                int secondInt = sc.nextInt();
                edgeNodes.add(firstInt);
                edgeNodes.add(secondInt);
            }


            int sourceNum = sc.nextInt();
            for (Integer num: nodeValues) {
                if(num == sourceNum){
                    continue;
                }
                if(edgeNodes.contains(num)){
                    System.out.print("6 ");
                }else {
                    System.out.print("-1 ");
                }
            }
            nodeValues.clear();
            edgeNodes.clear();

        }
    }
}

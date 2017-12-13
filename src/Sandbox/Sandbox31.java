package Sandbox;

import interviewCake.GraphNode;

import java.util.*;

public class Sandbox31 {

    private Set<String> getColors() {

        Set<String> colorSet = new HashSet<>();
        colorSet.add("yellow");
        colorSet.add("blue");
        colorSet.add("red");
        //colorSet.add("green");

        return colorSet;
    }

    private void colorNode(GraphNode g){
        Set<String> colorLib = getColors();
        Set<String> colorSet = new HashSet<>();
        for (GraphNode n: g.getNeighbors()) {
            if(n.hasColor()){
                colorSet.add(n.getColor());
            }
        }
        for (String col: colorLib) {
            if(!colorSet.contains(col)){
                g.setColor(col);
                break;
            }
        }
    }

    public void color(List<GraphNode> graph){

        Queue<GraphNode> gQueue = new LinkedList<>();
        GraphNode node = graph.get(0);
        gQueue.add(node);
        while (!gQueue.isEmpty()){
            GraphNode nd = gQueue.poll();
            if (!nd.hasColor()){
                colorNode(nd);
            }
            for (GraphNode n: nd.getNeighbors()) {
                if (!n.hasColor()){
                    colorNode(n);
                    gQueue.add(n);
                }
            }
        }

        System.out.println("Done");

    }

     public static void main(String [] arg){
         GraphNode a = new GraphNode("a");
         GraphNode b = new GraphNode("b");
         GraphNode c = new GraphNode("c");
         /*GraphNode d = new GraphNode("d");
         GraphNode e = new GraphNode("e");
         GraphNode f = new GraphNode("f");*/

         a.addNeighbor(b);
         a.addNeighbor(c);
         b.addNeighbor(a);
         b.addNeighbor(c);
         //b.addNeighbor(f);
         c.addNeighbor(a);
         c.addNeighbor(b);
         //c.addNeighbor(d);
         //c.addNeighbor(f);
         //d.addNeighbor(c);
         //d.addNeighbor(e);
         //e.addNeighbor(d);
         //e.addNeighbor(f);
         //f.addNeighbor(c);
         //f.addNeighbor(e);
         //f.addNeighbor(b);

         List<GraphNode> graph = Arrays.asList(a, b, c);
         Sandbox31 sb = new Sandbox31();
         sb.color(graph);
     }
}

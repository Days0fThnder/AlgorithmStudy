package NodeLib;

import java.util.*;

/**
 * Created by j_rus on 4/30/2016.
 */
public class GraphWork {


    public static void main(String arg[]){
            Scanner sc = new Scanner("12 15\n" + "14 9\n" + "12 14\n" + "14 10\n" + "14 12");
            Node node = null;
            int nodeData = -1;
            Set nodes = new HashSet();
            Set sourceNodes = new HashSet();
            List<GraphEdge> edges = new ArrayList<>();
            List<Node> adjNodes = new ArrayList<>();

            while(sc.hasNext()){
                Integer nodeNum1 = sc.nextInt();
                Integer nodeNum2 = sc.nextInt();
                edges.add(new GraphEdge(nodeNum1, nodeNum2));

                nodes.add(nodeNum1);
                nodes.add(nodeNum2);

            }
            for (int i=0; i < edges.size()-1; i++) {
                sourceNodes.add(edges.get(i).sourceNodeData);
            }
            for(Object n : sourceNodes){
                node = new Node((int)n);
                for(int i=0; i <= edges.size()-1; i++){
                    if(edges.get(i).sourceNodeData == node.getData()){
                        adjNodes.add(new Node(edges.get(i).adjNodeData));
                    }
                }
                node.setAdjList(adjNodes);
                System.out.println("The data for this "+node.toString());
                System.out.print("AdjList:");
                for (Node adj : node.getAdjList()) {
                    System.out.println(adj);
                }
                adjNodes.clear();
            }

            System.out.println("////////////////////////");
            System.out.println("All the graph's node(s)");
            for(Object n : nodes) {
                System.out.println(new Node((int) n).toString());
            }
        }
    }


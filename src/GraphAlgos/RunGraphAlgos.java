package GraphAlgos;

import DFSsearch.Graph;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by j_rus on 4/14/2016.
 */
public class RunGraphAlgos {
    

    public static void main(String [] args) throws IOException{
       /* BSTAlgos bst = new BSTAlgos();
        bst.insert(10, "DeSean Jackson");
        bst.insert(23, "Michael Jordan");
        bst.insert(33, "Dave Graig");
        bst.insert(16, "Joe Montana");
        bst.insert(2, "Derick Jeter");
        bst.insert(12, "Terry BradShaw");
        bst.insert(7, "John Elway");
        bst.insert(3, "Allen Iverson");
        bst.insert(10, "DeSean Jackson");


        System.out.println("\n// in order traversal\n");
        bst.inOrderTraversal(bst.root);
        System.out.println("\n// pre order traversal\n");
        bst.preOrderTraversal(bst.root);
        System.out.println("\n//post order traversal\n");
        bst.postOrderTraversal(bst.root);
        System.out.println("\n//recursive search\n");
        System.out.println(bst.recursiveSearch(bst.root, 12));
        System.out.println("\nDelete a Node\n");
        System.out.println(bst.delete(bst.root, 12));
        System.out.println(bst.recursiveSearch(bst.root, 12));
        */
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter graph input file name: ");
        String file = sc.nextLine();
        Graph graph = new Graph(file);
        //graph.print();
        graph.dfs();
    }
}

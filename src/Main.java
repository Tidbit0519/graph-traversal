import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Node starter;
    private static List<Node> nodes;

    /**
     * The main method that takes in user input.
     * Prints the neighboring nodes of each node.
     * @param args
     */
    public static void main(String[]args) {
        nodes = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String nodeNames = s.nextLine();
        String[] names = nodeNames.split(" ");
        //Instantiate a Node object for each encountered Node name.
        for(var name: names) {
            Node n = new Node(name);
            nodes.add(n);
        }
        //The starting Node of the traversal.
        String starterName = s.nextLine();
        starter = findNodeByName(starterName);
        while(true) {
            String a = s.next();
            //Breaks the loop when the last line of "***" is encountered.
            if(a.equals("***")) {
                break;
            }
            //Add the nodes into the current Node's neighbors ArrayList.
            Node n1 = findNodeByName(a);
            String b = s.next();
            Node n2 = findNodeByName(b);
            n1.addNeighbor(n2);
            n2.addNeighbor(n1);
        }

        System.out.println("Node neighbors: ");
        for(Node n: nodes) {
            n.printNeighbors();
        }

        System.out.println();
        System.out.println("Depth-First Search: ");
        depthFirst(starter);

        for(Node n : nodes) {
            n.visited = false;
        }

        System.out.println("");
        System.out.println("Breath-First Search: ");
        breathFirst(starter);
    }

    /**
     * Returns the Node object by passing the name into the parameter.
     * @param name Node name
     * @return Node object
     */
    private static Node findNodeByName(String name) {
        for(Node n: nodes) {
            if(name.equals(n.name)) {
                return n;
            }
        }
        return null;
    }

    /**
     * Prints the nodes in depth-first traversal oder.
     * @param n Node object
     */
    private static void depthFirst(Node n) {
        //Marks eac visited node and prints them.
        n.visited = true;
        System.out.print(n.name + " ");
        //Loops through the current node's neighboring nodes and calls the recursive function.
        for(Node neighborNode : n.neighbors) {
            if(!neighborNode.visited) {
                depthFirst(neighborNode);
            }
        }
    }

    /**
     * Prints the nodes in breadth-first traversal order.
     * @param n Node object
     */
    private static void breathFirst(Node n) {
        //Acts as a placeholder to keep track of the breadth-first traversal.
        List<Node> breadthFirstNodes = new ArrayList<>();
        //Marks each visited node and prints them.
        n.visited = true;
        System.out.print(n.name + " ");
        //The first Node in the placeholder list will be looped to mark its neighboring nodes as visited.
        breadthFirstNodes.add(n);
        while(breadthFirstNodes.size() != 0) {
            for(Node neighborNode : breadthFirstNodes.get(0).neighbors) {
                if(!neighborNode.visited) {
                    neighborNode.visited = true;
                    System.out.print(neighborNode.name + " ");
                    breadthFirstNodes.add(neighborNode);
                }
            }
            //If all neighboring nodes of the current node are visited, removes from the list.
            breadthFirstNodes.remove(0);
        }
        //The loop will start at the next Node which is now the first Node of the placeholder list.
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Node starter;
    private static List<Node> nodes;

    public static void main(String[]args) {
        nodes = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String nodeNames = s.nextLine();
        String[] names = nodeNames.split(" ");
        for(var name: names) {
            Node n = new Node(name);
            nodes.add(n);
        }
        String starterName = s.nextLine();
        starter = findNodeByName(starterName);
        while(true) {
            String a = s.next();
            if(a.equals("***")) {
                break;
            }
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

        System.out.println();
        System.out.println("Breath-First Search: ");
        breathFirst(starter);
    }

    private static Node findNodeByName(String name) {
        for(Node n: nodes) {
            if(name.equals(n.name)) {
                return n;
            }
        }
        return null;
    }

    private static void depthFirst(Node n) {
        n.visited = true;
        System.out.print(n.name + " ");
        for(Node neighborNode : n.neighbors) {
            if(!neighborNode.visited) {
                depthFirst(neighborNode);
            }
        }
    }

    private static void breathFirst(Node n) {
        List<Node> breadthFirstNodes = new ArrayList<>();
        n.visited = true;
        System.out.print(n.name + " ");
        breadthFirstNodes.add(n);
        while(breadthFirstNodes.size() != 0) {
            for(Node neighborNode : breadthFirstNodes.get(0).neighbors) {
                if(!neighborNode.visited) {
                    neighborNode.visited = true;
                    System.out.print(neighborNode.name + " ");
                    breadthFirstNodes.add(neighborNode);
                }
            }
            breadthFirstNodes.remove(0);
        }
    }


}

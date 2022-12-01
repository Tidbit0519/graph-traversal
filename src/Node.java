import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node implements Comparable<Node>{
    public String name;
    public List<Node> neighbors;
    public boolean visited;

    /**
     * Constructor to instantiate a Node object with name(String), neighbors(ArrayList), and visited(boolean).
     * @param n Node name
     */
    public Node(String n) {
        name = n;
        neighbors = new ArrayList<>();
        visited = false;
    }

    /**
     * Add a neighbor node to the current Node's neighbors ArrayList. Sort them in alphabetical order.
     * @param other Node object
     */
    public void addNeighbor(Node other) {
        neighbors.add(other);
        Collections.sort(neighbors);
    }

    /**
     * Compares current Node name with the other Node name lexicographically.
     * @param other Node object
     * @return Node name
     */
    @Override
    public int compareTo(Node other) {
        return name.compareTo(other.name);
    }

    /**
     * Print neighboring nodes of each node.
     */
    public void printNeighbors() {
        List<String> listString = new ArrayList<>();
        for(Node n: neighbors) {
            listString.add(n.name);
        }
        System.out.println(name + ": " + String.join(" ", listString));
    }
}

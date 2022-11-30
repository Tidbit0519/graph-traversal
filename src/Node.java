import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node implements Comparable<Node>{
    public String name;
    public List<Node> neighbors;
    public boolean visited;

    public Node(String n) {
        name = n;
        neighbors = new ArrayList<>();
        visited = false;
    }

    public void addNeighbor(Node other) {
        neighbors.add(other);
        Collections.sort(neighbors);
    }

    @Override
    public int compareTo(Node other) {
        return name.compareTo(other.name);
    }

    public void printNeighbors() {
        List<String> listString = new ArrayList<>();
        for(Node n: neighbors) {
            listString.add(n.name);
        }
        System.out.println(name + ": " + String.join(" ", listString));
    }
}

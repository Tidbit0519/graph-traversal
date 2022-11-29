import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Node implements Comparable<Node>{
    public String name;
    private List<Node> neighbors;

    public Node(String n) {
        name = n;
        neighbors = new ArrayList<>();
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

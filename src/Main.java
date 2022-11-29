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
        for(Node n: nodes) {
            n.printNeighbors();
        }
    }

    private static Node findNodeByName(String name) {
        for(Node n: nodes) {
            if(name.equals(n.name)) {
                return n;
            }
        }
        return null;
    }
}

package dijkstra;

import java.util.HashSet;
import java.util.Set;

public class SetGraph implements Graph{

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    @Override
    public void printNodes() {
        for(Node node : nodes){
            System.out.println(node.getName() + ": " + node.getDistance());
        }
    }

}

package dijkstra;

import java.util.HashMap;
import java.util.Map;

public class MapGraph implements Graph{

    private final Map<String, Node> nodes = new HashMap<>();

    public void addNode(Node nodeA) {
        nodes.put(nodeA.getName(), nodeA);
    }

    @Override
    public void printNodes() {
        for(Node node : nodes.values()){
            if(node.getDistance() < Long.MAX_VALUE) {
                System.out.println(node.getName() + ": " + node.getDistance());
            }
        }
    }

    @Override
    public Node getNodeByName(String name){
        return nodes.get(name);
    }

    @Override
    public boolean contains(Node node) {
        return nodes.containsValue(node);
    }

    @Override
    public long getDistanceToNode(Node node) {
        if(node != null && this.contains(node)) {
            return node.getDistance();
        }
        return Long.MAX_VALUE;
    }

}

package dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DoubleNode implements Node{

    private String name;

    private List<Node> shortestPath = new LinkedList<>();

    private Number distance = Double.MAX_VALUE;

    Map<Node, Number> adjacentNodes = new HashMap<>();

    public DoubleNode(String name) {
        this.name = name;
    }

    public void addDestination(Node destination, Number distance) {
        adjacentNodes.put(destination, distance);
    }

    public void setDistance(Number distance){
        this.distance = distance;
    }

    public Number getDistance() {
        return distance;
    }

    public Map<Node, Number> getAdjacentNodes() {
        return adjacentNodes;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    @Override
    public String getName() {
        return name;
    }

}

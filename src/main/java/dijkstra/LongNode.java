package dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LongNode implements Node{

    private final String name;

    private List<Node> shortestPath = new LinkedList<>();

    private long distance = Long.MAX_VALUE;

    Map<Node, Long> adjacentNodes = new HashMap<>();

    public LongNode(String name) {
        this.name = name;
    }

    public void addDestination(Node destination, long distance) {
        adjacentNodes.put(destination, distance);
    }

    public void setDistance(long distance){
        this.distance = distance;
    }

    public long getDistance() {
        return distance;
    }

    public Map<Node, Long> getAdjacentNodes() {
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

    @Override
    public void printShortestPath() {
        System.out.println("-------------------------");
        for(Node node : getShortestPath()) {
            System.out.println("Stop: " + node.getName() + " dist: " + node.getDistance());
        }
        System.out.println();
    }

    public boolean equals(Object o) {
        if(o instanceof Node){
            return this.getName().equals(((Node) o).getName());
        }
        else return false;
    }
}

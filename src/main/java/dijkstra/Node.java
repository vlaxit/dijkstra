package dijkstra;

import java.util.List;
import java.util.Map;

public interface Node {

    public void addDestination(Node destination, Number distance);

    public void setDistance(Number distance);

    public Number getDistance();

    public Map<Node, Number> getAdjacentNodes();

    public List<Node> getShortestPath();

    public void setShortestPath(List<Node> shortestPath);

    public String getName();

}

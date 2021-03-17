package dijkstra;

import java.util.List;
import java.util.Map;

public interface Node {

    void addDestination(Node destination, long distance);

    void setDistance(long distance);

    long getDistance();

    Map<Node, Long> getAdjacentNodes();

    List<Node> getShortestPath();

    void setShortestPath(List<Node> shortestPath);

    String getName();

    void printShortestPath();

}

package dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DijkstraCalculator {

    public Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0d);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Number> adjacencyPair:
                    currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Number edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private Node getLowestDistanceNode(Set <Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        Number lowestDistance = Double.MAX_VALUE;
        for (Node node: unsettledNodes) {
            Number nodeDistance = node.getDistance();
            if (nodeDistance.doubleValue() < lowestDistance.doubleValue()) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
    private void calculateMinimumDistance(Node evaluationNode,
                                          Number edgeWeigh, Node sourceNode) {
        Number sourceDistance = sourceNode.getDistance();
        if (sourceDistance.doubleValue() + edgeWeigh.doubleValue() < evaluationNode.getDistance().doubleValue()) {
            evaluationNode.setDistance(sourceDistance.doubleValue() + edgeWeigh.doubleValue());
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}

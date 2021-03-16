package calc;

import dijkstra.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraSPCalculatorTest {

    @Test
    void calculateShortestPath() {
        DijkstraCalculator dijkstraCalculator = new DijkstraCalculator();
        Node nodeA = new DoubleNode("A");
        Node nodeB = new DoubleNode("B");
        Node nodeC = new DoubleNode("C");
        Node nodeD = new DoubleNode("D");
        Node nodeE = new DoubleNode("E");
        Node nodeF = new DoubleNode("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new SetGraph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = dijkstraCalculator.calculateShortestPathFromSource(graph, nodeA);
        graph.printNodes();

    }
}
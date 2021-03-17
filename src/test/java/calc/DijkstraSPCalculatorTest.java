package calc;

import static org.assertj.core.api.Assertions.assertThat;
import dijkstra.*;
import domain.Route;
import io.GraphFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.RouteGraph;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

class DijkstraSPCalculatorTest {

    private LongDijkstraCalculator dijkstraCalculator;

    @BeforeEach
    public void setUp(){
        dijkstraCalculator = new LongDijkstraCalculator();
    }

    @Test
    void calculateShortestPath() {
        Node nodeA = new LongNode("A");
        Node nodeB = new LongNode("B");
        Node nodeC = new LongNode("C");
        Node nodeD = new LongNode("D");
        Node nodeE = new LongNode("E");
        Node nodeF = new LongNode("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new MapGraph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = dijkstraCalculator.calculateShortestPathFromSource(graph, nodeA);
        graph.printNodes();
        assertThat(graph.getDistanceToNode(nodeB)).isEqualTo(10L);
        assertThat(graph.getDistanceToNode(nodeC)).isEqualTo(15L);
        assertThat(graph.getDistanceToNode(nodeD)).isEqualTo(22L);
        assertThat(graph.getDistanceToNode(nodeE)).isEqualTo(24L);
        assertThat(graph.getDistanceToNode(nodeF)).isEqualTo(23L);
    }

    @Test
    void calculateShortestRoute() {
        Path resourcePath = Paths.get("src","test","resources", "routes.txt");
        String fileName = resourcePath.toString();
        GraphFileReader graphFileReader = new GraphFileReader();
        List<Route> result = graphFileReader.readNodesFromFile(fileName);
        RouteGraph routeGraph = new RouteGraph();
        for(Route route: result){
            routeGraph.addRouteToGraph(route);
        }
        Node first = routeGraph.getNodeByName("BEG");
        if(first!=null) {
            Graph resultingGraph = dijkstraCalculator.calculateShortestPathFromSource(routeGraph, first);
            resultingGraph.printNodes();

            Node YZF = resultingGraph.getNodeByName("YZF");
            //AKI: 25299
            Node AKI = resultingGraph.getNodeByName("AKI");

            System.out.println("<Price from BEG to YZF: " + YZF.getDistance() + ">");
            YZF.printShortestPath();

            System.out.println("<Price from BEG to AKI: " + AKI.getDistance() + ">");
            AKI.printShortestPath();

            assertThat(YZF.getDistance()).isEqualTo(10948L);
            assertThat(AKI.getDistance()).isEqualTo(22097L);
        }
    }
}
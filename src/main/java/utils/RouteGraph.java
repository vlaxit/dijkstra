package utils;

import dijkstra.Graph;
import dijkstra.LongNode;
import dijkstra.MapGraph;
import dijkstra.Node;
import domain.Route;

public class RouteGraph extends MapGraph implements Graph {

    public void addRouteToGraph(Route route) {
        Node a = super.getNodeByName(route.getFrom().getName());
        if(a == null) {
            a = new LongNode(route.getFrom().getName());
        }
        Node b = super.getNodeByName(route.getTo().getName());
        if(b == null) {
            b = new LongNode(route.getTo().getName());
        }
        if(!a.getAdjacentNodes().containsKey(b) || (a.getAdjacentNodes().containsKey(b) && a.getAdjacentNodes().get(b) > route.getCost())) {
            a.addDestination(b, route.getCost());
        }
        super.addNode(a);
        super.addNode(b);
    }

}

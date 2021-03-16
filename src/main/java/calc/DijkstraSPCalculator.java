package calc;

import dijkstra.DijkstraCalculator;
import dijkstra.Graph;
import domain.City;
import domain.Route;

import java.util.List;
import java.util.Set;

public class DijkstraSPCalculator {

    private DijkstraCalculator dijkstraCalculator = new DijkstraCalculator();

    public List<Route> calculateShortestPath(City from, City to, Set<Route> allRoutes){

        Graph allCities = null;
        CityNode node = null;
        Graph calculatedNodes = dijkstraCalculator.calculateShortestPathFromSource(allCities, node);
        return null;
    }

}

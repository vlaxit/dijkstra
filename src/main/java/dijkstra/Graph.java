package dijkstra;

public interface Graph {

    public void addNode(Node nodeA);

    public void printNodes();

    public Node getNodeByName(String name);

    public boolean contains(Node node);

    public long getDistanceToNode(Node node);

}

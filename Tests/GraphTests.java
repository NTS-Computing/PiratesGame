import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTests {
    @Test
    public void it_will_create_an_empty_graph(){
        Graph g = new Graph();

        assertTrue(g.getEdges().size() == 0);
    }

    @Test
    public void it_will_populate_a_graph_with_a_list_of_vertices(){
        Graph g = new Graph();

        Vertex v1 = new Vertex("London");
        Vertex v2 = new Vertex("Manchester");

        g.addVertex(v1);
        g.addVertex(v2);

        System.out.println(g.getVertices());

        assertTrue(g.containsVertex(new Vertex("London")));
        assertTrue(g.containsVertex(new Vertex("Manchester")));
        assertFalse(g.containsVertex(new Vertex("Liverpool")));
    }

    @Test
    public void it_will_not_permit_the_addition_of_an_edge_between_the_same_name(){
        Graph g = new Graph();

        Vertex v1 = new Vertex("London");
        Vertex v2 = new Vertex("Manchester");

        g.addVertex(v1);
        g.addVertex(v2);

        assertTrue(g.containsVertex(v1));
        assertTrue(g.containsVertex(v2));

        g.addEdge(v1, v1);

        assertFalse(g.containsEdge(new Edge(v1, v1)));
    }

    @Test
    public void it_will_not_permit_the_addition_of_duplicate_edges(){
        Graph g = new Graph();

        Vertex v1 = new Vertex("London");
        Vertex v2 = new Vertex("Manchester");

        g.addVertex(v1);
        g.addVertex(v2);

        g.addEdge(v1, v2);

        assertEquals(1, g.getEdges().size());

        Vertex v3 = new Vertex("London");
        Vertex v4 = new Vertex("Manchester");

        g.addVertex(v3);
        g.addVertex(v4);

        g.addEdge(v3, v4);

        assertEquals(1, g.getEdges().size());
    }
}

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {
    @Test
    public void it_will_create_an_empty_graph(){
        Graph g = new Graph();

        assertTrue(g.getEdges().size() == 0);
    }

    @Test
    public void it_will_populate_a_graph_with_a_list_of_vertices(){
        Graph g = new Graph();

        g.addVertex(new Vertex("London"));
        g.addVertex(new Vertex("Manchester"));

        assertTrue(g.containsVertex(new Vertex("London")));
        assertTrue(g.containsVertex(new Vertex("Manchester")));
        assertFalse(g.containsVertex(new Vertex("Liverpool")));
    }

    @Test(expected = DuplicateEdgeException.class)
    public void we_cant_add_duplicate_edge(){
        Vertex vertex1 = new Vertex("London");
        Vertex vertex2 = new Vertex("Machester");

        Edge e = new Edge(vertex1, vertex2);

        Graph g = new Graph();

        g.addEdge(e);
        g.addEdge(e);
    }

    @Test
    public void we_can_rebuild_the_3rd_reich(){
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("Witney");
        Vertex v3 = new Vertex("Swindon");
        Vertex v4 = new Vertex("Carterton");

        Graph g = new Graph();

        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);

        g.removeVertex("Swindon");
    }

}
//http://www.dreamincode.net/forums/topic/377473-graph-data-structure-tutorial/
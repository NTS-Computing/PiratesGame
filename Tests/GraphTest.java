import org.junit.Test;

import java.util.HashMap;
import java.util.Set;

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
    public void we_can_remove_vertices_with_both_methods(){
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
        g.removeVertex(v4);

        assertEquals(2, g.getVertices().size());
    }

    @Test
    public void we_can_add_edges_with_both_methods(){
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("Witney");
        Vertex v3 = new Vertex("Swindon");
        Vertex v4 = new Vertex("Carterton");

        Graph g = new Graph();

        g.addEdge(v1, v2, 5);
        g.addEdge(v1, v3);

        assertEquals(2, g.getEdges().size());
    }

    //@TODO: Figure out why this test doesn't pass
    //@TODO: Test weather we can remove more edges than we add

    @Test
    public void we_can_remove_edges_we_both_methods(){
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("Witney");
        Vertex v3 = new Vertex("Swindon");
        Vertex v4 = new Vertex("Carterton");

        Edge e = new Edge(v1,v2);

        Graph g = new Graph();

        g.addEdge(e);
        g.addEdge(v1,v3);
        g.addEdge(v1,v4);
        g.addEdge(v2, v4);

        g.removeEdge(e);
        g.removeEdge(v1, v3);

        assertEquals(2,g.getEdges().size());
    }

    @Test
    public void we_can_return_the_correct_hashmap_for_vertices(){
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("Witney");

        Graph g = new Graph();

        g.addVertex(v1);
        g.addVertex(v2);

        HashMap<String, Vertex> returnedVertices = g.getVertices();

        assertEquals(2, returnedVertices.size());
        assertEquals(true, returnedVertices.containsKey("Oxford"));
        assertEquals(v1, returnedVertices.get("Oxford"));
        assertEquals(true, returnedVertices.containsKey("Witney"));
        assertEquals(v2, returnedVertices.get("Witney"));
    }

    @Test
    public void we_can_get_the_correct_set_of_verticies(){
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("Witney");

        Graph g = new Graph();

        g.addVertex(v1);
        g.addVertex(v2);

        Set<Vertex> vSet = g.vertexKeys();

        assertEquals(2,vSet.size());
        assertEquals(true,vSet.contains());
        assertTrue(vSet.contains(v2.hashCode()));
    }

}
//http://www.dreamincode.net/forums/topic/377473-graph-data-structure-tutorial/
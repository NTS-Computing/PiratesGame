import com.piratesgame.graph.Edge;
import com.piratesgame.graph.exceptions.EdgeLoopException;
import com.piratesgame.graph.Graph;
import com.piratesgame.graph.Vertex;
import org.junit.Test;

import static org.junit.Assert.*;

public class EdgeTest {
    @Test
    public void it_can_create_a_simple_edge(){
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("Liverpool");

        Edge e = new Edge(v1, v2);

        assertEquals("Liverpool", e.getVertexOne().getLabel());
        assertEquals("Manchester", e.getVertexTwo().getLabel());
    }

    @Test
    public void it_defaults_unspecified_weights_to_zero(){
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("Liverpool");

        Edge e = new Edge(v1, v2);

        assertEquals(1, e.getWeight());
    }

    @Test
    public void it_can_create_a_weighted_edge(){
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("Liverpool");

        Edge e = new Edge(v1, v2, 5);

        assertEquals("Liverpool", e.getVertexOne().getLabel());
        assertEquals("Manchester", e.getVertexTwo().getLabel());
        assertEquals(5, e.getWeight());
    }

    @Test
    public void it_can_provide_the_neighbour_of_a_vertex_on_an_edge(){
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("Swansea");

        Edge e = new Edge(v1, v2);

        Vertex opposite1 = e.getNeighbour(v1);
        assertEquals("Swansea", opposite1.getLabel());

        Vertex opposite2 = e.getNeighbour(v2);
        assertEquals("Manchester", opposite2.getLabel());
    }

    @Test
    public void it_doesnt_return_the_neighbour_on_an_edge_if_we_dont_give_a_valid_vertex(){
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("Swansea");
        Vertex v3 = new Vertex("London");

        Edge e = new Edge(v1, v2);

        Vertex nullOpposite = e.getNeighbour(v3);
        assertNull(nullOpposite);
    }

    @Test
    public void we_will_add_vertices_to_an_edge_the_right_way_round(){
        Vertex v1 = new Vertex("London");
        Vertex v2 = new Vertex("Manchester");

        Edge e1 = new Edge(v1, v2);
        Edge e2 = new Edge(v2, v1);

        assertEquals("London",e1.getVertexOne().getLabel());
        assertEquals("Manchester",e1.getVertexTwo().getLabel());
        assertEquals("London",e2.getVertexOne().getLabel());
        assertEquals("Manchester",e2.getVertexTwo().getLabel());
    }

    @Test
    public void it_will_confirm_equivalence_of_edges(){
        Vertex v1 = new Vertex("London");
        Vertex v2 = new Vertex("Manchester");
        Vertex v3 = new Vertex("Liverpool");

        Edge e1 = new Edge(v1, v2);
        Edge e2 = new Edge(v1, v2);

        assertTrue((e1.equals(e2)));
    }

    @Test
    public void we_can_get_a_standardized_lable_output(){
        Vertex v1 = new Vertex("Swansea");
        Vertex v2 = new Vertex("Witney");

        Edge e = new Edge(v1,v2);

        assertEquals("({Swansea, Witney}, 1)",e.toString());
    }

    @Test(expected = EdgeLoopException.class)
    public void we_cant_make_an_edge_that_has_two_vertexes_the_same(){
        Vertex v = new Vertex("Plymouth");

        Edge e = new Edge(v,v);
    }

    @Test
    public void we_can_test_to_see_if_two_edges_are_equal(){
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("GoldSmith");
        Vertex v3 = new Vertex("Witney");

        Edge e1 = new Edge(v1, v2);
        Edge e2 = new Edge(v1, v3);
        Edge e3 = new Edge(v2, v3);
        Edge e4 = new Edge(v1, v2);

        Graph g = new Graph();

        g.addEdge(e1);
        g.addEdge(e2);

        boolean test1 = e1.equals(e4);
        boolean test2 = e1.equals(e2);
        boolean test3 = e1.equals(e1);
        boolean test4 = e2.equals(e3);
        boolean test5 = e1.equals(v1);

        assertTrue(test1);
        assertFalse(test2);
        assertTrue(test3);
        assertFalse(test4);
        assertFalse(test5);
    }
}
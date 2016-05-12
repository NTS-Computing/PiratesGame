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

//    @Test
//    public void it_will_correctly_compare_the_weights_of_edges(){
//        Vertex v1 = new Vertex("London");
//        Vertex v2 = new Vertex("Manchester");
//        Vertex v3 = new Vertex("Liverpool");
//
//        Edge e1 = new Edge(v1, v2, 5);
//        Edge e2 = new Edge(v1, v3, 3);
//
//        assertTrue((e1.compareTo(e2) > 0));
//        assertTrue((e2.compareTo(e1) < 0));
//    }

//    @Test
//    public void it_will_correctly_compare_the_weights_of_equal_edges(){
//        Vertex v1 = new Vertex("London");
//        Vertex v2 = new Vertex("Manchester");
//        Vertex v3 = new Vertex("Liverpool");
//
//        Edge e1 = new Edge(v1, v2);
//        Edge e2 = new Edge(v1, v3);
//
//        assertTrue((e1.compareTo(e2) == 0));
//        assertTrue((e2.compareTo(e1) == 0));
//    }

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
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("Witney");

        Edge e = new Edge(v1,v2);

        assertEquals("({Oxford, Witney}, 1)",e.toString());
    }

    @Test
    public void we_can_compare_two_edges_that_are_differvnt(){
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("Witney");
        Vertex v3 = new Vertex("Swindon");
        Vertex v4 = new Vertex("Carterton");

        Edge e1 = new Edge(v1,v2);
        Edge e2 = new Edge(v3,v4);

        assertFalse(e1.equals(e2));
    }

    @Test(expected = EdgeLoopException.class)
    public void we_cant_make_an_edge_that_has_two_vertexes_the_same(){
        Vertex v = new Vertex("Oxford");

        Edge e = new Edge(v,v);
    }
}
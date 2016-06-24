import com.piratesgame.graph.*;
import com.piratesgame.graph.exceptions.NoEdgeException;
import com.piratesgame.graph.vertices.PortVertex;
import com.piratesgame.graph.vertices.SeaVertex;
import com.piratesgame.graph.vertices.Vertex;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class VertexTest {
    @Test
    public void it_can_create_an_empty_node() {
        Vertex v = new Vertex();

        assertNull(v.getLabel());
    }

    @Test
    public void it_should_store_its_label() {
        Vertex v = new Vertex("Manchester");

        assertEquals("Manchester", v.getLabel());
    }

    @Test
    public void it_can_add_a_neighbour() {
        Vertex v1 = new Vertex("London");
        Vertex v2 = new Vertex("Penzance");

        Edge e = new Edge(v1, v2);

    }

    @Test
    public void it_can_verify_that_two_vertices_are_equal() {
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("Manchester");

        assertTrue(v1.equals(v2));
    }

    @Test
    public void it_outputs_the_correct_toString_representation() {
        Vertex v1 = new Vertex("London");

        assertEquals("Vertex: London", v1.toString());
    }

    @Test
    public void we_can_add_a_edge_to_a_neighbourhood() {
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("Swindon");
        Edge e = new Edge(v1, v2);

        v1.addNeighbour(e);

        assertEquals("({Oxford, Swindon}, 1)", v1.getNeighbour(1).toString());
    }

    @Test
    public void we_can_remove_edges_from_a_neighbourhood() {
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("Swindon");
        Vertex v3 = new Vertex("Witney");

        Edge e1 = new Edge(v1, v2);
        Edge e2 = new Edge(v1, v3);

        v1.addNeighbour(e1);
        v1.addNeighbour(e2);

        v1.removeNeighbour(e1);
        v1.removeNeighbour(1);

        assertEquals(0, v1.getNeighbourCount());
    }

    @Test
    public void we_can_get_the_neighbourhood() {
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("Swindon");
        Vertex v3 = new Vertex("Witney");
        Vertex v4 = new Vertex("Carterton");

        Edge e1 = new Edge(v1, v2);
        Edge e2 = new Edge(v1, v3);
        Edge e3 = new Edge(v1, v4);

        v1.addNeighbour(e1);
        v1.addNeighbour(e2);

        ArrayList<Edge> Hoodlist = v1.getNeighbourhood();

        assertTrue(Hoodlist.contains(e1));
        assertTrue(Hoodlist.contains(e2));
        assertFalse(Hoodlist.contains(e3));
    }

    @Test
    public void we_can_get_a_neighbour_using_edges(){
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("Swindon");
        Vertex v3 = new Vertex("Witney");

        Edge e1 = new Edge(v1, v2);
        Edge e2 = new Edge(v1, v3);

        v1.addNeighbour(e1);
        v1.addNeighbour(e2);

        assertEquals(e1, v1.getNeighbour(e1));
        assertEquals(e2, v1.getNeighbour(e2));
    }

    @Test(expected = NoEdgeException.class)
    public void it_will_throw_an_exception_if_the_edge_is_not_found(){
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("Swindon");
        Vertex v3 = new Vertex("Witney");

        Edge e1 = new Edge(v1, v2);
        Edge e2 = new Edge(v1, v3);

        v1.addNeighbour(e1);

        assertEquals(e2,v1.getNeighbour(e2));
    }

    @Test
    public void we_can_see_if_a_vertex_has_a_certain_neighbour(){
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("Swindon");
        Vertex v3 = new Vertex("Witney");

        Edge e1 = new Edge(v1, v2);
        Edge e2 = new Edge(v1, v3);

        v1.addNeighbour(e1);

        assertTrue(v1.containsNeighbour(e1));
        assertFalse(v1.containsNeighbour(e2));
    }

    @Test
    public void we_can_compare_vertices(){
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("Swindon");
        Vertex v3 = new Vertex("Witney");

        Edge e1 = new Edge(v1, v2);
        Edge e2 = new Edge(v1, v3);

        assertTrue(v1.equals(v1));
        assertFalse(v1.equals(v2));
        assertFalse(v1.equals(e1));
        assertTrue(v3.equals(v3));
    }

    @Test(expected = NoEdgeException.class)
    public void we_cant_remove_more_edges_than_we_have_added(){
        Vertex v1 = new Vertex("Oxford");
        Vertex v2 = new Vertex("Swindon");
        Vertex v3 = new Vertex("Witney");

        Edge e1 = new Edge(v1, v2);
        Edge e2 = new Edge(v1, v3);

        v1.addNeighbour(e1);
        v1.addNeighbour(e2);

        v1.removeNeighbour(e1);
        v1.removeNeighbour(e2);
        v1.removeNeighbour(e1);
    }

    @Test
    public void we_can_use_and_produce_a_correct_hash(){
        Vertex v1 = new Vertex("Oxford");
        assertEquals(-1919292860, v1.hashCode());
    }

    @Test
    public void we_can_create_a_graph_of_sea_and_port_vertices_with_edges(){
        SeaVertex seaAB = new SeaVertex("sea AB");
        SeaVertex seaAC = new SeaVertex("sea AC");
        SeaVertex seaBC = new SeaVertex("sea BC");
        PortVertex a = new PortVertex("Port A");
        PortVertex b = new PortVertex("Port B");
        PortVertex c = new PortVertex("Port C");

        Edge portASeaAB = new Edge(a,seaAB);
        Edge portBSeaAB = new Edge(b,seaAB);
        Edge portASeaAC = new Edge(a,seaAC);
        Edge portCSeaAC = new Edge(c,seaAC);
        Edge portBSeaBC = new Edge(c,seaBC);
        Edge seaABSeaBC = new Edge(seaBC,seaAB);
        Edge seaABSeaAC = new Edge(seaAC,seaAB);
        Edge seaACSeaBC = new Edge(seaBC,seaAC);

        Graph g = new Graph();

        g.addVertex(seaAB);
        g.addVertex(seaAC);
        g.addVertex(seaBC);
        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);

        g.addEdge(portASeaAB);
        g.addEdge(portBSeaAB);
        g.addEdge(portASeaAC);
        g.addEdge(portCSeaAC);
        g.addEdge(portBSeaBC);
        g.addEdge(seaABSeaBC);
        g.addEdge(seaABSeaAC);
        g.addEdge(seaACSeaBC);

        assertTrue(g.containsEdge(portCSeaAC));
        assertTrue(g.containsEdge(seaABSeaBC));
        assertTrue(g.containsVertex(seaAB));
        assertTrue(g.containsVertex(b));
    }
}


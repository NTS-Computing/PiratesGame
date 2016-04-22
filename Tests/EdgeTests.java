import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EdgeTests {

    @Test
    public void can_we_set_weight(){
        Vertex v1 = new Vertex("London");
        Vertex v2 = new Vertex("Oxford");
        Edge e = new Edge(v1, v2);
        e.setWeight(5);

        assertEquals(5,e.getWeight());
    }
}

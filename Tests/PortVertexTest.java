import com.piratesgame.graph.vertices.PortVertex;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PortVertexTest {

    @Test
    public void create_a_port_vertex_with_string(){
        PortVertex vP = new PortVertex("Priest Cove");

        assertEquals("Priest Cove", vP.getLabel());
    }
}

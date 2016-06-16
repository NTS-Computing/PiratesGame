import com.piratesgame.graph.vertices.SeaVertex;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SeaVertexTest {

    @Test
    public void create_a_sea_vertex_with_string(){
        SeaVertex vS = new SeaVertex("Atlantic sea");

        assertEquals("Atlantic sea",vS.getLabel());
    }

}

import com.piratesgame.graph.vertices.IslandVertex;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IslandVertexTest {

    @Test
    public void we_can_create_an_island_vertex_with_a_string(){
        IslandVertex vI = new IslandVertex("Ireland");

        assertEquals("Ireland", vI.getLabel());
    }
}

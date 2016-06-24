import org.junit.Test;
import com.piratesgame.collectibles.treasure.Gold;

import static org.junit.Assert.assertEquals;

public class GoldTest {

    @Test
    public void the_limit_is_set_to_20(){
        Gold g = new Gold();

        g.increase(25);

        assertEquals(20,g.quantity());
    }

}

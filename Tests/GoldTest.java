import org.junit.Test;
import com.piratesgame.collectibles.treasure.Gold;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.assertEquals;

public class GoldTest {

    @Test
    public void we_can_create_some_gold(){
        Gold g = new Gold();
    }

    @Test
    public void we_can_add_to_gold(){
        Gold g = new Gold();
        g.increase(5);

        assertEquals(5,g.quantity());
    }

    @Test
    public void we_can_set_a_limit(){
        Gold g = new Gold();
        g.increase(21);

        assertEquals(20, g.quantity());
    }

    @Test
    public void gold_cant_be_below_0(){
        Gold g = new Gold();
        g.decrease(5);

        assertEquals(0,g.quantity());
    }
}

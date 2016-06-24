import com.piratesgame.collectibles.Collectible;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollectibleTest {

    @Test
    public void we_can_create_some_collectibles(){
        Collectible c = new Collectible();
    }

    @Test
    public void we_can_add_to_collectibles(){
        Collectible c = new Collectible();
        c.setLimit(10);
        c.increase(5);

        assertEquals(5,c.quantity());
    }

    @Test
    public void we_can_set_a_limit(){
        Collectible c = new Collectible();
        c.setLimit(20);
        c.increase(21);

        assertEquals(20, c.quantity());
    }

    @Test
    public void we_can_remove_collectibles(){
        Collectible c = new Collectible();
        c.setLimit(10);
        c.increase(6);
        c.decrease(5);

        assertEquals(1, c.quantity());
    }

    @Test
    public void collectibles_cant_be_below_0(){
        Collectible c = new Collectible();
        c.decrease(5);

        assertEquals(0,c.quantity());
    }
}

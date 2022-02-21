package fanfic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(value = "Hyperspace")
class HyperspaceTest {

    @Test
    void hyperspaceBasicTest() {
        Hyperspace hyperspace = new Hyperspace();
        assertEquals(0, hyperspace.getShipsCount());
        assertTrue(hyperspace.addShip(new Ship("name", new Coords(1.0, 1.0, 1.0), null, null)));
        assertEquals(1, hyperspace.getShipsCount());
    }

}
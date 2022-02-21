package fanfic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName(value = "Engine test")
class EngineTest {

    @Test
    void engineBasicTest() {
        Engine engine = new Engine(3.1,23,1);
        assertEquals(3.1, engine.getHP());
        assertEquals(23, engine.getVolume());
        assertEquals(1, engine.getConsumption());
    }
}
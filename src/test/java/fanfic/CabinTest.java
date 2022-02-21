package fanfic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(value = "CabinTest")
class CabinTest {

    @Test
    void cabinBasicTest() {
        Cabin cabin = new Cabin(new Door(DoorMaterial.METAL,123,false), null, 23, 123);
        assertEquals(123, cabin.getCabinNumber());
        assertNull(cabin.getPeople());
        assertFalse(cabin.rushCabin(100));
        assertTrue(cabin.rushCabin(400));
    }

}
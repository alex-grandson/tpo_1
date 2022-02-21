package fanfic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    @Test
    void personTest() {
        Person person = new Person("Arthur", "Cock");
        assertEquals("Arthur", person.getName());
        assertEquals("Cock", person.getRole());
    }
}

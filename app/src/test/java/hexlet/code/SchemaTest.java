package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SchemaTest {

    private static final int NUMBER_LENGTH = 12;
    private static final int NUMBER_ONE = 10;
    private static final int NUMBER_TWO = 5;

    @Test
    public void stringSchemaTest() {
        var valid1 = new Validator();
        var schema = valid1.string();
        assertTrue(schema.isValid(""));

        schema.required();
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("n"));

        assertTrue(schema.minLength(1).isValid("noko"));
        assertFalse(schema.minLength(NUMBER_LENGTH).isValid("one"));

        assertTrue(schema.contains("dog").isValid("my dog is best"));
        assertFalse(schema.contains("qrt").isValid("number"));

        var schema1 = valid1.string();
        assertTrue(schema1.isValid(""));
    }

    @Test
    public void numberSchemaTest() {
        var valid1 = new Validator();
        var schema = valid1.number();
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(1));

        schema.range(1, NUMBER_ONE);
        assertTrue(schema.isValid(NUMBER_ONE));
        schema.range(1, NUMBER_ONE);
        assertFalse(schema.isValid(NUMBER_LENGTH));

        schema.positive();
        assertTrue(schema.isValid(NUMBER_TWO));
        assertFalse(schema.isValid(-1));

        var schema1 = valid1.number();
        assertTrue(schema1.isValid(null));
    }

    @Test
    public void mapSchemaTest() {
        var valid1 = new Validator();
        var schema = valid1.map();
        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(Map.of()));

        schema.sizeof(2);
        assertTrue(schema.isValid(Map.of(
                "one", 1,
                "two", 2
        )));
        assertFalse(schema.isValid(Map.of(
                "One", 1,
                "Two", 2,
                "Three", NUMBER_TWO
        )));


    }
}

package hexlet.code;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SchemaTest {

    private static final int NUMBER_LENGTH = 12;
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
}

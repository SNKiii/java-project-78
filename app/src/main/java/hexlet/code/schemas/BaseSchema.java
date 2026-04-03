package hexlet.code.schemas;

import hexlet.code.Predicate;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseSchema<T> {
    protected boolean required = false;
    protected Map<String, Predicate<T>> check = new HashMap<>();

    protected void addCheck (String name, Predicate<T> validate) {
        check.put(name, validate);
    }

    public final boolean isValid (T value) {
        if((required && value == null) || (required && value instanceof String && ((String) value).isEmpty())) {
            return false;
        }

        for (String key : check.keySet()) {
            if (!check.get(key).checking(value)) {
                return false;
            }
        }
        return true;
    }
}

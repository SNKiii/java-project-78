package hexlet.code.schemas;

import hexlet.code.Predicate;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseSchema<T> {
    private boolean required = false;
    private Map<String, Predicate<T>> check = new HashMap<>();

    protected final void setRequired(boolean bool) {
        this.required = bool;
    }
    protected final void addCheck(String name, Predicate<T> validate) {
        check.put(name, validate);
    }

    public final boolean isValid(T value) {
        if ((required && value == null) || (required && value instanceof String && ((String) value).isEmpty())) {
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

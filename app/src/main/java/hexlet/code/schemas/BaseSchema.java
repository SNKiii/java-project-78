package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private boolean required = false;
    private Map<String, Predicate<T>> check = new HashMap<>();

    protected final void setRequired(boolean bool) {
        this.required = bool;
    }
    protected final void addCheck(String name, Predicate<T> validate) {
        check.put(name, validate);
    }

    public final void setCheck(Map<String, Predicate<T>> newCheck) {
        this.check = newCheck;
    }

    public final boolean isValid(T value) {
        if ((required && value == null) || (required && value instanceof String && ((String) value).isEmpty())) {
            return false;
        }

        for (String key : check.keySet()) {
            if (!check.get(key).test(value)) {
                return false;
            }
        }
        return true;
    }
}

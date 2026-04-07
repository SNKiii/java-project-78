package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class  MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema() {
        super();
    }

    public final MapSchema required() {
        setRequired(true);
        return this;
    }

    public final MapSchema sizeof(int number) {
        Predicate<Map<?, ?>> test = (map) -> map != null && map.size() == number;
        addCheck("sizeof", test);
        return this;
    }

    public final <T> MapSchema shape(Map<String, BaseSchema<T>> map) {
        Predicate<Map<?, ?>> test = (newMap) -> {
            for (Map.Entry<String, BaseSchema<T>> entry : map.entrySet()) {
                String key = entry.getKey();
                BaseSchema<T> schema = entry.getValue();
                T value = (T) newMap.get(key);

                if (!schema.isValid(value)) {
                    return false;
                }
            }
            return true;
        };
        addCheck("shape", test);
        return this;
    }
}


package hexlet.code.schemas;

import hexlet.code.Predicate;

import java.util.Map;

public class  MapSchema<T, V> extends BaseSchema<Map<T, V>> {
    protected Integer limit;
    private Map<String, BaseSchema<V>> schemas;

    public MapSchema() {
        super();
    }

    public MapSchema<T, V> required() {
        required = true;
        return this;
    }

    public MapSchema<T, V> sizeof(int number) {
        Predicate<Map<T, V>> test = new Predicate<>((map) -> map.size() == number);
        addCheck("sizeof", test);
        return this;
    }

    public final MapSchema<T, V> shape(Map<String, BaseSchema<V>> map) {
        Predicate<Map<T, V>> test = new Predicate<>((newMap) -> {
            for (Map.Entry<String, BaseSchema<V>> entry : map.entrySet()) {
                String key = entry.getKey();
                BaseSchema<V> schema = entry.getValue();
                V value = newMap.get(key);

                return schema.isValid(value);
        }
            return true;
        });
        addCheck("shape", test);
        this.schemas = map;
        return this;
    }
}

package hexlet.code.schemas;

import java.util.Map;

public class  MapSchema<T, V> extends BaseSchema<Map<T, V>> {
    private Integer limit;
    private Map<String, BaseSchema<V>> schemas;;

    public MapSchema() {
        super();
    }

    private void setLimit(int newLimit) {
        limit = newLimit;
    }


    public final void sizeof(int number) {
        if (number < 0) {
            setLimit(Math.abs(number));
        } else {
            setLimit(number);
        }
    }

    public final MapSchema<T, V> shape(Map<String, BaseSchema<V>> map) {
        this.schemas = map;
        return this;
    }

    @Override
    protected final boolean validate(Map<T, V> map) {
        if (limit != null) {
            if (map.size() != limit) {
                return false;
            }
        }
        if (schemas != null) {
            for (Map.Entry<String, BaseSchema<V>> entry : schemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema<V> schema = entry.getValue();
                V value = map.get(key);
                if (!schema.isValid(value)) {
                    return false;
                }
            }
        }
        return true;
    }
}

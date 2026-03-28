package hexlet.code.schemas;

import java.util.Map;

public class  MapSchema<T, V> extends BaseSchema<Map<T, V>> {
    private Integer limit;

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

    @Override
    protected final boolean validate(Map<T, V> map) {
        if (limit != null) {
            if (map.size() != limit) {
                return false;
            }
        }
        return true;
    }
}

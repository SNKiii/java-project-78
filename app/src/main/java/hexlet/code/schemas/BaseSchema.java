package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    private int ifNull = 0;

    public final void required() {
        setIfNull(1);
    }

    private void setIfNull(Integer newIfNull) {
        this.ifNull = newIfNull;
    }

    public final boolean isValid(T data) {
        if (data instanceof String) {
            if (ifNull != 0 && ((String) data).isEmpty()) {
                return  false;
            }
        }
        if (ifNull != 0 && data == null) {
            return  false;
        }
        return validate(data);
    }

    protected abstract boolean validate(T data);
}

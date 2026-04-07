package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        super();
    }

    public NumberSchema required() {
        setRequired(true);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> test = (number) -> number == null || number > 0;
        addCheck("positive", test);
        return this;
    }

    public NumberSchema range(int start, int end) {
        Predicate<Integer> test = (number) -> number != null && number >= start && number <= end;
        addCheck("range", test);
        return this;
    }

}

package hexlet.code.schemas;

import hexlet.code.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        super();
    }

    public NumberSchema required() {
        required = true;
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> test = new Predicate<>((number) -> number >= 0);
        addCheck("positive", test);
        return this;
    }

    public NumberSchema range(int start, int end) {
        Predicate<Integer> test = new Predicate<>((number) -> number >= start && number <= end);
        addCheck("range", test);
        return this;
    }

}

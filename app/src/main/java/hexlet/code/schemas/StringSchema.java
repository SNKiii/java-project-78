package hexlet.code.schemas;

import hexlet.code.Predicate;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema() {
        super();
    }

    public StringSchema required() {
        setRequired(true);
        return this;
    }

    public StringSchema minLength(int min) {
    Predicate<String> test = new Predicate<>((line) -> line.length() >= min);
    addCheck("minLength", test);
    return this;
    }

    public StringSchema contains(String line) {
        Predicate<String> test = new Predicate<>((string) -> string.contains(line));
        addCheck("contains", test);
        return this;
    }
}


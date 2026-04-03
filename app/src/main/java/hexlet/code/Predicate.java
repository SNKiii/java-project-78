package hexlet.code;


public class Predicate <T> {
    private Function<T> test;
    public Predicate(Function<T> newTest) {
        this.test = newTest;
    }

    public boolean checking (T value) {
        return test.checkup(value);
    }
}

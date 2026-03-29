package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    private int signLimit = 0;
    private Integer[] range;

    public NumberSchema() {
        super();
    }


    private void setSignLimit(int count) {
        signLimit = count;
    }

    private void  setRange(Integer[] newRange) {
        range = newRange;
    }

    public NumberSchema positive() {
        setSignLimit(1);
        return this;
    }

    public NumberSchema range(int start, int end) {
        Integer[] newRange = new Integer[(end - start) + 1];
        int count = 0;
        for (int i = start; i <= end; i++) {
            newRange[count] = i;
            count++;
        }
        setRange(newRange);
        return this;
    }

    @Override
    protected boolean validate(Integer number) {
        if (signLimit != 0) {
            if (number < 0) {
                return false;
            }
        }

        if (range != null) {
            for (int i = 0; i < range.length; i++) {
                if (number.equals(range[i])) {
                    return true;
                }
            }
        return  false;
        }

        return true;
    }
}

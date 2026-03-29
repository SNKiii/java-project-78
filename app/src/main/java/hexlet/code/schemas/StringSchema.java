package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    private Integer ifMin;
    private String mandatoryLine;

    public StringSchema() {
        super();
    }

    private void setIfMin(int newIfMin) {

        this.ifMin = newIfMin;
    }

    private void setMandatoryLine(String newMandatoryLine) {

        this.mandatoryLine = newMandatoryLine;
    }


    public StringSchema minLength(int min) {
        if (min >= 0) {
            setIfMin(min);
            return this;
        } else {
            setIfMin(Math.abs(min));
            return this;
        }
    }

    public StringSchema contains(String line) {
        setMandatoryLine(line);
        return this;
    }

    @Override
    protected boolean validate(String line) {
        if (ifMin != null) {
            if (line.length() < ifMin) {
                return false;
            }
        }

        if (mandatoryLine != null) {
            return line.contains(mandatoryLine);
        }

        return true;
    }
}

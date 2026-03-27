package hexlet.code.schemas;

public class StringSchema {

    private int ifNull = 0;
    private Integer ifMin;
    private String mandatoryLine;

    public StringSchema() { }

    private void setIfNull(Integer newIfNull) {
        this.ifNull = newIfNull;
    }
    private void setIfMin(int newIfMin) {
        this.ifMin = newIfMin;
    }

    private void setMandatoryLine(String newMandatoryLine) {
        this.mandatoryLine = newMandatoryLine;
    }

    public final void required() {
        setIfNull(1);
    }

    public final StringSchema minLength(int min) {
        if (min >= 0) {
            setIfMin(min);
            return this;
        } else {
            setIfMin(Math.abs(min));
            return this;
        }
    }

    public final StringSchema contains(String line) {
        setMandatoryLine(line);
        return this;
    }

    public final boolean isValid(String line) {
        if (ifNull == 1) {
            if (line.isEmpty()) {
                return false;
            }
        }

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

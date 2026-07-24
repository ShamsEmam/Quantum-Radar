import java.math.BigDecimal;

public class Violation {

    private final String ruleName;
    private final String description;
    private final BigDecimal fee;


    public Violation(String ruleName, String description, BigDecimal fee) {
        this.ruleName = ruleName;
        this.description = description;
        this.fee = fee;
    }
    public String getRuleName() {
        return ruleName;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getFee() {
        return fee;
    }
}
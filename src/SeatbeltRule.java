import java.math.BigDecimal;

public class SeatbeltRule implements Rule {

    private static final BigDecimal FEE = BigDecimal.valueOf(100);
    private static final String RULE_NAME = "SeatbeltRule";

    @Override
    public String getRuleName() {
        return RULE_NAME;
    }

    @Override
    public Violation check(Observation observation) {

        if (!observation.isSeatbeltFastened()) {
            return new Violation(RULE_NAME, "Seatbelt not fastned", FEE);
        }

        return null;
    }
}
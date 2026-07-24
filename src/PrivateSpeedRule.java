import java.math.BigDecimal;

public class PrivateSpeedRule implements Rule {
    private static final String RULE_NAME = "SpeedRule";
    private static final int MAX_SPEED = 80;
    private static final BigDecimal FEE = BigDecimal.valueOf(300);

    @Override
    public String getRuleName() {
        return RULE_NAME;
    }

    @Override
    public Violation check(Observation observation) {

        if (observation.getCarType() != CarType.PRIVATE) {
            return null;
        }

        if (observation.getSpeed() > MAX_SPEED) {

            String description =
                    "speed of " + observation.getSpeed()
                            + " exceeded max allowed " + MAX_SPEED;

            return new Violation(RULE_NAME, description, FEE);
        }

        return null;
    }
}
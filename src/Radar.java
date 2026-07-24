import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Radar {
    private List<Rule> rules;
    private List<Fine> fines;

    public Radar() {
        this.rules = new ArrayList<>();
        this.fines = new ArrayList<>();
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public Fine processObservation(Observation observation) {
        List<Violation> violations = new ArrayList<>();

        for (Rule rule : rules) {
            Violation violation = rule.check(observation);
            if (violation != null) {
                violations.add(violation);
            }
        }

        if (violations.isEmpty()) {
            return null;
        }

        Fine fine = new Fine(observation.getPlateNumber(), violations);
        fines.add(fine);
        return fine;
    }

    public Map<String, BigDecimal> getAllPossibleFines() {
        Map<String, BigDecimal> totalsByPlate = new HashMap<>();

        for (Fine fine : fines) {
            String plate = fine.getPlateNumber();
            BigDecimal existing = totalsByPlate.getOrDefault(plate, BigDecimal.ZERO);
            totalsByPlate.put(plate, existing.add(fine.getTotalAmount()));
        }

        return totalsByPlate;
    }

    public Map<String, Integer> getViolatedRulesCount() {
        Map<String, Integer> counts = new HashMap<>();

        for (Fine fine : fines) {
            for (Violation violation : fine.getViolations()) {
                String ruleName = violation.getRuleName();
                counts.put(ruleName, counts.getOrDefault(ruleName, 0) + 1);
            }
        }

        return counts;
    }
}
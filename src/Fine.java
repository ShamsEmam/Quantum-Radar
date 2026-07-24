import java.math.BigDecimal;
import java.util.List;

public class Fine {

    private final String plateNumber;
    private final List<Violation> violations;

    public Fine(String plateNumber, List<Violation> violations) {
        this.plateNumber = plateNumber;
        this.violations = violations;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public BigDecimal getTotalAmount() {
        BigDecimal total = BigDecimal.ZERO;

        for (Violation v : violations) {
            total = total.add(v.getFee());
        }

        return total;
    }

    public void print() {
        System.out.println("Traffic fine for car " + plateNumber);
        System.out.println("Total amount: " + getTotalAmount() + " EGP");
        System.out.println("Violations:");
        for (Violation v : violations) {
            System.out.println("- " + v.getDescription() + " : " + v.getFee() + " EGP");
        }
    }
}
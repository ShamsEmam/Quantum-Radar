import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Radar radar = new Radar();

        radar.addRule(new SeatbeltRule());
        radar.addRule(new PrivateSpeedRule());
        radar.addRule(new TruckSpeedRule());

        Observation observation = new Observation(
                "ABC1234",
                LocalDate.now(),
                CarType.PRIVATE,
                94,
                false
        );
        Observation observation2 = new Observation(
                "ABC12345",
                LocalDate.now(),
                CarType.PRIVATE,
                60,
                false
        );


        Fine fine = radar.processObservation(observation);
        Fine fine2 = radar.processObservation(observation2);


        if (fine != null) {
            fine.print();
        }

        if (fine2 != null) {
            fine2.print();
        }

        System.out.println("\n--- All Fines ---");
        radar.getAllPossibleFines().forEach((plate, sum) ->
                System.out.println("Plate: " + plate + " | Total: " + sum + " EGP")
        );

        System.out.println("\n--- Violated Rules Count ---");
        radar.getViolatedRulesCount().forEach((rule, count) ->
                System.out.println("Rule: " + rule + " | Count: " + count)
        );
    }
}
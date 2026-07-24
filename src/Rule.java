public interface Rule {

    Violation check(Observation observation);
    String getRuleName();
}
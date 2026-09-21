package stack;

public class TreatmentRecord {
    private final int patientId;
    private final String treatmentDetails;

    public TreatmentRecord(int patientId, String treatmentDetails) {
        this.patientId = patientId;
        this.treatmentDetails = treatmentDetails;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    @Override
    public String toString() {
        return "TreatmentRecord{" +
                "patientId=" + patientId +
                ", treatmentDetails='" + treatmentDetails + '\'' +
                '}';
    }
}

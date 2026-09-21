package linkedlist;

public class VisitRecord {
    private final int visitId;
    private final String visitDate;
    private final String doctorName;
    private final String diagnosis;
    private final String treatment;

    public VisitRecord(int visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public int getVisitId() {
        return visitId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    @Override
    public String toString() {
        return "VisitRecord{" +
                "visitId=" + visitId +
                ", visitDate='" + visitDate + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }
}
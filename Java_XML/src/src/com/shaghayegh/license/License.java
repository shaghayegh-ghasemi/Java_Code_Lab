package com.shaghayegh.license;


public class License {
    private String NIPR_number;
    private String state_code;
    private String license_number;
    private String license_issue_date;
    private String license_expiration_date;
    private String resident;
    private String license_class;
    private String license_status;

    public License(String NIPR_number, String state_code, String license_number,
                   String license_issue_date, String license_expiration_date,
                   String resident, String license_class, String license_status) {
        this.NIPR_number = NIPR_number;
        this.state_code = state_code;
        this.license_number = license_number;
        this.license_issue_date = license_issue_date;
        this.license_expiration_date = license_expiration_date;
        this.resident = resident;
        this.license_class = license_class;
        this.license_status = license_status;
    }

    // Getters
    public String getNiprNumber() { return NIPR_number; }
    public String getStateCode() { return state_code; }
    public String getLicenseNumber() { return license_number; }
    public String getLicenseIssueDate() { return license_issue_date; }
    public String getLicenseExpirationDate() { return license_expiration_date; }
    public String getResident() { return resident; }
    public String getLicenseClass() { return license_class; }
    public String getLicenseStatus() { return license_status; }

    // Create a composite key for merging
    public String getCompositeKey() {
        return NIPR_number + "_" + state_code + "_" + license_number + "_" + license_issue_date;
    }

    @Override
    public String toString() {
        return "License{" +
                "NIPR=" + NIPR_number +
                ", State=" + state_code +
                ", License#=" + license_number +
                ", Issue=" + license_issue_date +
                ", Expiry=" + license_expiration_date +
                ", Resident Indicator=" + resident +
                ", CLass=" + license_class +
                ", Status=" + license_status +
                '}';
    }


}
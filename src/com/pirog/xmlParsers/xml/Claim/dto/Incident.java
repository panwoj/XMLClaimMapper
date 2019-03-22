package com.pirog.xmlParsers.xml.Claim.dto;

public class Incident {
    private String details;
    private String severity;

    public Incident(String details, String severity) {
        this.details = details;
        this.severity = severity;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return details;
    }
}

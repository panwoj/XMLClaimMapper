package com.pirog.xmlParsers.xml.Claim.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class LossDetails {
    private LocalDateTime lossDate;
    private Incident incident;

    public LossDetails(LocalDateTime lossDate, Incident incident) {
        this.lossDate = lossDate;
        this.incident = incident;
    }

    public LocalDateTime getLossDate() {
        return lossDate;
    }

    public void setLossDate(LocalDateTime lossDate) {
        this.lossDate = lossDate;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    @Override
    public String toString() {
        return "LossDetails{" +
                "lossDate=" + lossDate +
                ", incident=" + incident +
                '}';
    }
}

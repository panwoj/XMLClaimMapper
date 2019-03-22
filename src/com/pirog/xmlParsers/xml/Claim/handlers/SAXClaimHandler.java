package com.pirog.xmlParsers.xml.Claim.handlers;

import com.pirog.xmlParsers.xml.Claim.dto.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SAXClaimHandler extends DefaultHandler {
    private Claim claim;
    private Incident incident;
    private LossDetails lossDetails;
    private Person claimant;
    private Policy policy;
    private String content;
    private List<Person> reporters;
    private boolean isClaimant;

    public Claim getClaim() {
        return claim;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Claim")) {
            policy = new Policy("");
            incident = new Incident("", "");
            lossDetails = new LossDetails(null, incident);
            claimant = new Person("", "", "");
            claim = new Claim(Long.parseLong(attributes.getValue("id")), policy, lossDetails, claimant);
        }
        if (qName.equals("Claimant")) {
            isClaimant = true;
        }
        if (qName.equals("Reporter")) {
            isClaimant = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "LossDate":
                lossDetails.setLossDate(LocalDateTime.parse(content));
                break;
            case "Incident":
                incident.setDetails(content);
                break;
            case "Severity":
                incident.setSeverity(content);
                break;
            case "PolicyNumber":
                policy.setNumber(content);
                break;
            case "Name":
                if(isClaimant) {
                    claimant.setName(content);
                } else {
                    if (reporters == null) {
                        reporters = new ArrayList<>();
                        claim.getPersons().put("reporters", reporters);
                    }
                    reporters.add(new Person(content, "", ""));
                }
                break;
            case "LastName":
                if(isClaimant) {
                    claimant.setLastName(content);
                } else {
                    reporters.get(reporters.size() - 1).setLastName(content);
                }
                break;
            case "PhoneNumber":
                if(isClaimant) {
                    claimant.setPhone(content);
                } else {
                    reporters.get(reporters.size() - 1).setPhone(content);
                }
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = String.copyValueOf(ch, start, length);
    }
}

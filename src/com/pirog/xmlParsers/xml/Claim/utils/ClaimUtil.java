package com.pirog.xmlParsers.xml.Claim.utils;

import com.pirog.xmlParsers.xml.Claim.dto.Claim;
import com.pirog.xmlParsers.xml.Claim.dto.Person;

import java.util.List;

public class ClaimUtil {

    public static Person getClaimant(Claim claim) {
        return claim.getPersons().get("claimant").get(0);
    }

    public static List<Person> getReporters(Claim claim) {
        return claim.getPersons().get("reporters");
    }
}

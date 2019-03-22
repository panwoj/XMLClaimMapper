package com.pirog.xmlParsers.xml.Claim.domMapping;

import com.pirog.xmlParsers.xml.Claim.dto.*;
import com.pirog.xmlParsers.xml.Claim.enums.PersonRole;
import com.pirog.xmlParsers.xml.Claim.utils.ClaimDomMapperUtil;
import org.w3c.dom.Document;

import java.time.LocalDateTime;

public class ClaimDomMapper {
    public static Claim mappClaimFromXMLDocument(Document document) {


        //        creating Incident object
        String details = ClaimDomMapperUtil.getStringByXmlTag("Incident", document);
        String severity = ClaimDomMapperUtil.getStringByXmlTag("Severity", document);
        Incident incident = new Incident(details, severity);

        //        creating LossDetails object
        CharSequence dateChars = document.getElementsByTagName("LossDate").item(0).getTextContent();
        LocalDateTime date = LocalDateTime.parse(dateChars);
        LossDetails lossDetails = new LossDetails(date, incident);

        //        creating Policy object
        String policyNumber = ClaimDomMapperUtil.getStringByXmlTag("PolicyNumber", document);
        Policy policy = new Policy(policyNumber);

        //        creating claimant Person object
        Person claimant = PersonDomMapper.mapPersonFromXMLDocument(PersonRole.CLAIMANT.getRole(), document, 0);

//        creating Claim object
        String id = ClaimDomMapperUtil.getStringAttributeFromXml("Claim", "id", document);
        Claim claim = new Claim(Long.parseLong(id), policy, lossDetails, claimant);


        // creating other Person objects
        PersonDomMapper.mapOtherPersons(document, claim);
        return claim;

    }


}

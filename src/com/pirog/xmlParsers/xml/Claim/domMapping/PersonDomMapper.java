package com.pirog.xmlParsers.xml.Claim.domMapping;

import com.pirog.xmlParsers.xml.Claim.dto.Claim;
import com.pirog.xmlParsers.xml.Claim.dto.Person;
import com.pirog.xmlParsers.xml.Claim.enums.PersonRole;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

public class PersonDomMapper {

    public static Person mapPersonFromXMLDocument(String role, Document document, int index) {
        String name = document.getElementsByTagName(role).item(0).getChildNodes().item(1).getTextContent();
        String lastName = document.getElementsByTagName(role).item(0).getChildNodes().item(3).getTextContent();
        String phone = document.getElementsByTagName(role).item(0).getChildNodes().item(5).getTextContent();
        return new Person(name, lastName, phone);
    }

    public static void mapOtherPersons(Document document, Claim claim) {
        int reporterNumber = document.getElementsByTagName("Reporter").getLength();
        if (reporterNumber > 0) {
            List<Person> reporters = new ArrayList<>();
            claim.getPersons().put("reporters", reporters);
            for (int i = 0; i < reporterNumber; i++) {
                Person person = mapPersonFromXMLDocument(PersonRole.REPORTER.getRole(), document, i);
                claim.getPersons().get("reporters").add(person);
            }
        }
    }
}

package com.pirog.xmlParsers.xml.Claim;

import com.pirog.xmlParsers.xml.Claim.domMapping.ClaimDomMapper;
import com.pirog.xmlParsers.xml.Claim.dto.Claim;
import com.pirog.xmlParsers.xml.Claim.utils.ClaimUtil;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ClaimDOMParser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document documentWithTwoReporters = documentBuilder.parse(ClassLoader.getSystemResourceAsStream("com/pirog/xmlParsers/xml/Claim/xml/ClaimWithTwoReporters.xml"));
        Document documentWithoutReporters = documentBuilder.parse(ClassLoader.getSystemResourceAsStream("com/pirog/xmlParsers/xml/Claim/xml/ClaimWithoutReporters.xml"));

        Claim claimWithReporters = ClaimDomMapper.mappClaimFromXMLDocument(documentWithTwoReporters);
        Claim claimWithoutReporters = ClaimDomMapper.mappClaimFromXMLDocument(documentWithoutReporters);
        System.out.println(claimWithReporters);
        System.out.println(ClaimUtil.getClaimant(claimWithReporters));
        System.out.println(ClaimUtil.getReporters(claimWithReporters));
        System.out.println(claimWithReporters.getLossDetails());
        System.out.println(claimWithoutReporters);
        System.out.println(ClaimUtil.getClaimant(claimWithoutReporters));
        System.out.println(ClaimUtil.getReporters(claimWithoutReporters));
        System.out.println(claimWithoutReporters.getLossDetails());


    }
}

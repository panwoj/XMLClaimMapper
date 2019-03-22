package com.pirog.xmlParsers.xml.Claim;

import com.pirog.xmlParsers.xml.Claim.dto.Claim;
import com.pirog.xmlParsers.xml.Claim.handlers.SAXClaimHandler;
import com.pirog.xmlParsers.xml.Claim.utils.ClaimUtil;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class ClaimSAXParser {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SAXClaimHandler handler = new SAXClaimHandler();
        parser.parse(ClassLoader.getSystemResourceAsStream("com/pirog/xmlParsers/xml/Claim/xml/ClaimWithTwoReporters.xml"), handler);
        Claim claim = handler.getClaim();

        System.out.println(claim);
        System.out.println(ClaimUtil.getClaimant(claim));
        System.out.println(ClaimUtil.getReporters(claim));
        System.out.println(claim.getLossDetails());

        parser.parse(ClassLoader.getSystemResourceAsStream("com/pirog/xmlParsers/xml/Claim/xml/ClaimWithoutReporters.xml"), handler);
        claim = handler.getClaim();

        System.out.println(claim);
        System.out.println(ClaimUtil.getClaimant(claim));
        System.out.println(ClaimUtil.getReporters(claim));
        System.out.println(claim.getLossDetails());
    }
}

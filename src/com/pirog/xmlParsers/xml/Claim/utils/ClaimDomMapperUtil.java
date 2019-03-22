package com.pirog.xmlParsers.xml.Claim.utils;

import org.w3c.dom.Document;

public class ClaimDomMapperUtil {
    public static String getStringByXmlTag(String tagName, Document document) {
        return document.getElementsByTagName(tagName).item(0).getTextContent();
    }

    public static String getStringAttributeFromXml(String tagName, String attributeName, Document document) {
        return document.getElementsByTagName(tagName).item(0).getAttributes().getNamedItem(attributeName).getTextContent();
    }
}

package com.shaghayegh.license;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<License> parse(String filePath) {
        List<License> licenses = new ArrayList<>();

        try {
            File inputFile = new File(filePath);
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList producerList = doc.getElementsByTagName("CSR_Producer");

            for (int i = 0; i < producerList.getLength(); i++) {
                Element producer = (Element) producerList.item(i);
                String NIPR_number = producer.getAttribute("NIPR_Number");

                NodeList licenseList = producer.getElementsByTagName("License");

                for (int j = 0; j < licenseList.getLength(); j++) {
                    Element license = (Element) licenseList.item(j);

                    String license_number = license.getAttribute("License_Number");
                    String state_code = license.getAttribute("State_Code");
                    String license_issue_date = license.getAttribute("License_Issue_Date");
                    String license_expiration_date = license.getAttribute("License_Expiration_Date");
                    String resident = license.getAttribute("Resident_Indicator");
                    String license_class =  license.getAttribute("License_Class");
                    String license_status =  license.getAttribute("License_Status");

                    // Add to list
                    License lic = new License(NIPR_number, state_code, license_number, license_issue_date, license_expiration_date, resident, license_class, license_status);
                    licenses.add(lic);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return licenses;
    }

}



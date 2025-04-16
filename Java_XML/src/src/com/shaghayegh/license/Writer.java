package com.shaghayegh.license;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


public class Writer {
    private static final String LICENSE_HEADER_ROW =
            "nipr, License ID, Jurisdiction, Resident, License Class," +
                    "License Effective Date, License Expiry Date, License Status," +
                    "License Line, License Line Effective Date, License Line Expiry Date, License Line Status";

    public static void writeToCSV(String filename, List<License> licenses) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(LICENSE_HEADER_ROW + "\n");

            for (License lic : licenses) {
                String line = String.join(",",
                        lic.getNiprNumber(),
                        lic.getLicenseNumber(),
                        lic.getStateCode(),
                        lic.getResident(),
                        lic.getLicenseClass(),
                        lic.getLicenseIssueDate(),
                        lic.getLicenseExpirationDate(),
                        lic.getLicenseStatus(),
                        "", "", "", ""
                );

                writer.write(line + "\n");
            }

            System.out.println("Wrote to " + filename);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + filename);
            e.printStackTrace();
        }
    }

    public static void writeMergedXml(String filename, Collection<License> licenses) {
        try {
            // Step 1: Group licenses by NIPR_Number
            Map<String, List<License>> grouped = new HashMap<>();
            for (License lic : licenses) {
                grouped.computeIfAbsent(lic.getNiprNumber(), k -> new ArrayList<>()).add(lic);
            }

            // Step 2: Create XML structure
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element root = doc.createElement("CSR_Report");
            doc.appendChild(root);

            Element header = doc.createElement("CSR_Report_Header");
            header.setAttribute("Report_Type", "Merged Report");
            header.setAttribute("Title", "Merged_Licenses");
            header.setAttribute("TimeStamp_Created", "04/11/2025");
            root.appendChild(header);

            Element body = doc.createElement("CSR_Report_Body");
            root.appendChild(body);

            for (Map.Entry<String, List<License>> entry : grouped.entrySet()) {
                String nipr = entry.getKey();
                Element producer = doc.createElement("CSR_Producer");
                producer.setAttribute("NIPR_Number", nipr);
                body.appendChild(producer);

                for (License lic : entry.getValue()) {
                    Element licenseEl = doc.createElement("License");
                    licenseEl.setAttribute("License_Number", lic.getLicenseNumber());
                    licenseEl.setAttribute("State_Code", lic.getStateCode());
                    licenseEl.setAttribute("License_Issue_Date", lic.getLicenseIssueDate());
                    licenseEl.setAttribute("License_Expiration_Date", lic.getLicenseExpirationDate());
                    licenseEl.setAttribute("License_Status", lic.getLicenseStatus());
                    licenseEl.setAttribute("License_Class", lic.getLicenseClass());
                    licenseEl.setAttribute("Resident_Indicator", lic.getResident());

                    producer.appendChild(licenseEl);
                }
            }

            // Step 3: Write to file
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource domSource = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            transformer.transform(domSource, result);

            System.out.println("Merged XML written to: " + filename);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


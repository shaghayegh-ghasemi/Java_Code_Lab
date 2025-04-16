package com.shaghayegh.license;

import java.text.SimpleDateFormat;
import java.util.*;

public class Filter {
    private static final String DATE_FORMAT = "MM/dd/yyyy";

    public static List<License> getValidLicenses(Collection<License> licenses) {
        List<License> valid = new ArrayList<>();
        Date today = new Date();
        for (License lic : licenses) {
            try {
                Date exp = new SimpleDateFormat(DATE_FORMAT).parse(lic.getLicenseExpirationDate());
                if (exp.after(today)) {
                    valid.add(lic);
                }
            } catch (Exception e) {
                System.out.println("Invalid date format in license: " + lic.getLicenseExpirationDate());
            }
        }
        return valid;
    }

    public static List<License> getInvalidLicenses(Collection<License> licenses) {
        List<License> invalid = new ArrayList<>();
        Date today = new Date();

        for (License lic : licenses) {
            try {
                Date exp = new SimpleDateFormat(DATE_FORMAT).parse(lic.getLicenseExpirationDate());
                if (!exp.after(today)) {
                    invalid.add(lic);
                }
            } catch (Exception e) {
                System.out.println("Invalid date format in license: " + lic.getLicenseExpirationDate());
            }
        }
        return invalid;
    }

}
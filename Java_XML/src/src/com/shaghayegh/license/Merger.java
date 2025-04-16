package com.shaghayegh.license;

import java.util.*;

public class Merger {
    public Map<String, License> mergeLicenses(List<License> list1, List<License> list2) {
        Map<String, License> mergedMap = new HashMap<>();
        for (License license : list1) {
            mergedMap.put(license.getCompositeKey(), license);
        }
        for (License license : list2) {
            mergedMap.put(license.getCompositeKey(), license); // overwrites if key already exists
        }
        return mergedMap;

    }
}
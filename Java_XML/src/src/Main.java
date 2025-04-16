import java.util.*;
import com.shaghayegh.license.License;
import com.shaghayegh.license.Parser;
import com.shaghayegh.license.Merger;
import com.shaghayegh.license.Filter;
import com.shaghayegh.license.Writer;


public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();

        List<License> licenses1 = parser.parse("src/resources/License1.xml");
        List<License> licenses2 = parser.parse("src/resources/License2.xml");

        Merger merger = new Merger();

        Map<String, License> mergedLicenses = merger.mergeLicenses(licenses1, licenses2);
        List<License> validLicenses = Filter.getValidLicenses(mergedLicenses.values());
        List<License> invalidLicenses = Filter.getInvalidLicenses(mergedLicenses.values());

        Writer.writeMergedXml("src/output/merged_licenses.xml", mergedLicenses.values());
        Writer.writeToCSV("src/output/valid_licenses.csv", validLicenses);
        Writer.writeToCSV("src/output/invalid_licenses.csv", invalidLicenses);

    }

} 

 
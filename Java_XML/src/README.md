# XML License Merger

This Java project merges two XML files containing license information based on unique keys and writes the result into:

- A merged XML file

- Valid licenses CSV (based on expiration date)

- Invalid licenses CSV



## Files

- License1.xml, License2.xml → Input XML files

- merged_licenses.xml → Combined output in XML format

- valid_licenses.csv, invalid_licenses.csv → Filtered CSVs



## Matching Keys

- Licenses are matched using the following fields:

- NIPR_Number

- State_Code

- License_Number

- License_Issue_Date



## Filtering

- Licenses with an expiration date after today are marked valid

- Others are invalid

- Date format used: MM/dd/yyyy


## Output Format

- CSV Header:
  "nipr, License ID, Jurisdiction, Resident, License Class ,License Effective Date,License Expiry Date,License Status,License Line,License Line Effective Date,License Line Expiry Date,License Line Status".

## Technologies

- Java (JDK 8+)

- DOM XML Parser

- SimpleDateFormat for date handling



## Author

Shaghayegh Ghasemi 
 
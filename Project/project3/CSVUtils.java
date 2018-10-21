/* source from
    https://www.mkyong.com/java/how-to-export-data-to-csv-file-java/
*/

import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';


    public static List<String> writeLine(String csvLine) {
        return writeLine(csvLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    public static List<String> writeLine(String csvLine, char separators) {
        return writeLine(csvLine, separators, DEFAULT_QUOTE);
    }

    public static List<String> writeLine(String csvLine, char separators, char customQuote) {

        List<String> result = new ArrayList<>();

        //if empty, return!
        if (csvLine == null && csvLine.isEmpty()) {
            return result;
        }
        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }
        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        char[] chars = csvLine.toCharArray();

        for (char ch : chars) {

            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {

                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }

                }
            } else {
                if (ch == separators) {
                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    startCollectChar = false;


                } else if (ch == customQuote) {

                    inQuotes = true;

                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }

                    //double quotes in column will hit this!
                    if (startCollectChar) {
                        curVal.append('"');
                    }
                } else if (ch == '\n') {
                    //the end, break!
                    break;
                } else {
                    curVal.append(ch);
                }
            }

        }

        result.add(curVal.toString());

        return result;
    }

}

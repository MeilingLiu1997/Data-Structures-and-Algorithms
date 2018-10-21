/* source from
    https://www.mkyong.com/java/how-to-export-data-to-csv-file-java/
    https://www.thepolyglotdeveloper.com/2015/03/parse-json-file-java/
*/

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class RecordLoader {
    public static Graph<String, Integer> fileReader(String filePath) {
        Graph<String, Integer> graph = new Graph<String, Integer>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line = null;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                List<String> record = CSVUtils.writeLine(line);
                line = br.readLine();

                String castString = record.get(2).replace("\"\"", "\"");
                if (castString.startsWith("\"")){
                    castString = castString.substring(1);
                }
                JSONArray jsonArrayCast = (JSONArray)JSONValue.parse(castString);
                List<String> list = new ArrayList<>();
                if (jsonArrayCast == null) {
                    System.out.println(castString);
                } else {
                    for (Object obj : jsonArrayCast) {
                        Map<String, String> cast = (Map<String, String>) obj;
                        list.add(cast.get("name"));
                    }
                }

                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        graph.addEdge(list.get(i), list.get(j), 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graph;
    }
}

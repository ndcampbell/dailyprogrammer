import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dcampbell on 4/26/16.
 */

public class SortCode {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = readLines("/User/dcampbell/test.txt");
        String test = sortCode(lines);
    }

    private static String sortCode(List<String> unsorted) {
        List<String> sorted = new ArrayList<>();
        List<String> outsideFunc = new ArrayList<>();
        List<String> insideFunc = new ArrayList<>();
        for (String line: unsorted) {
            if (line.substring(0, 2) == "  " ) {
                insideFunc.add(line);
            } else {
                outsideFunc.add(line);
            }
        }
        String inside = sortInside(insideFunc);
        System.out.print(inside);
        return "TEST";
    }

    private static String sortInside(List<String> insideUnsort) {
        List<String> cTypes = Arrays.asList("bool", "int", "char", "float", "double", "void");
        List<String> sorted = new ArrayList<>();
        for (String line: insideUnsort) {
            String subType = line.trim().substring(0, 3);
            if (cTypes.stream().anyMatch(str -> str.trim().equals(subType))) {
                sorted.add(1, line);
            } else {
                sorted.add(line);
            }

        }
        return sorted.toString();
    }

    private static List<String> readLines(String filename) throws IOException{
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines;

    }

}

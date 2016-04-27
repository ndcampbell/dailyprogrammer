import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dcampbell on 4/26/16.
 */

public class SortCode {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = readLines("test.txt");
        String test = sortCode(lines);
    }

    private static String sortCode(List<String> unsorted) {
        List<String> sorted = new ArrayList<>();
        List<String> outsideFunc = new ArrayList<>();
        List<String> insideFunc = new ArrayList<>();
        for (String line: unsorted) {
            if (line.length() >= 2) {
                if (line.substring(0, 2).trim().length() == 0 ) {
                    insideFunc.add(line);
                } else {
                    outsideFunc.add(line);
                }
            } else {
                outsideFunc.add(line);
            }
        }
        List<String> inside = sortInside(insideFunc);
        List<String> outside = sortOutside(outsideFunc);
        String joined = joinList(inside, outside);
        System.out.println(inside);
        System.out.println(joined);

        return "TEST";
    }

    private static String joinList(List<String> inside, List<String> outside ) {
        String joined;

        for (String line: inside) {
            outside.add(outside.size()-1, line);
        }
        joined = String.join("\n", outside);
        return joined;
    }

    private static List<String> sortInside(List<String> insideUnsort) {
        List<String> cTypes = Arrays.asList("bool", "int", "char", "float", "double", "void");
        List<String> loopTypes = Arrays.asList("for", "while");
        List<String> sorted = new ArrayList<>();
        List<String> loopSorted = new ArrayList<>();
        String subType;
        for (String line: insideUnsort) {
            if (line.trim().length() >= 3) {
                subType = line.trim().substring(0, 3);
                type_loop:
                for (String sub: cTypes){
                    if (sub.equals(subType)) {
                        sorted.add(0, line);
                        break type_loop;
                    }
                }
                sorted.add(line);
            } else {
                sorted.add(line);
            }
        }

        for (String line: sorted) {
            System.out.println(line);
            if (line.trim().length() > 1) {
                if (line.trim().substring(0, 3).equals("for") || line.trim().substring(0, 5).equals("while")) {
                    loopSorted.add(0, line);
                }
            }
            if (line.substring(0,2).equals("  ")) {
                    if (line.trim().substring(0,1).equals("{")) {
                        loopSorted.add(line);
                    }
                    else if (line.trim().substring(0,1).equals("}")) {
                        loopSorted.add(line);
                    }
                }
            try {
                if (line.substring(0, 4).equals("    ")) {
                    loopSorted.add(2, line);
                }
            }
            catch (IndexOutOfBoundsException e) {
                System.out.print("nothing");
            }
        }
        System.out.println(loopSorted);


        return sorted;
    }


    private static List<String> sortOutside(List<String> outsideUnsort) {
        List<String> sorted = new ArrayList<>();
        for (String line: outsideUnsort) {
            if (line.substring(0,1).equals("#")) {
                sorted.add(0,line);
            }
            else if (line.substring(0,1).equals("}")) {
                sorted.add(line);
            }
            else if (line.substring(0,1).equals("{")) {
                if (sorted.size() >=1 ) {
                    sorted.add(sorted.size() - 1, line);
                } else { sorted.add(line); }
            }
            else {
                sorted.add(1, line);
            }
        }
        return sorted;
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

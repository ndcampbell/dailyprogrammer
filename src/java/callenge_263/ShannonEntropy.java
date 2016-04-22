import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dcampbell on 4/20/16.
 */
public class ShannonEntropy {

    public static void main(String[] args) {
        for (String s: args) {
            Double test = entropy(s);
        }
    }

     private static Double entropy(String input) {
        int len = input.length();
        List<Double> valuelist;
        Double retValue = 0.0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();

        for (int i=0; i < len; i++) {
            char c = input.charAt(i);
            Integer val = map.get(new Character(c));
            if (val != null) {
                map.put(c, new Integer(val+1));
            }else{
                map.put(c,1);
            }
        }

        for (int i=0; i < len; i++) {
            char c = input.charAt(i);
            Integer val = map.get(new Character(c));
            Double tempval = (-1 * (val/len) * ((Math.log(val/len)/Math.log(2))));
            System.out.println(tempval);
        }

        return retValue;

    }


}

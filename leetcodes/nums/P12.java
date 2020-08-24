package nums;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月24日 10:00
 */
public class P12 {

    @Test
    public void testFunc() {
        int input = 1994;
        System.out.println(intToRoman(input));
    }

    public String intToRoman(int num) {
        if (num < 1 || num > 3999)
            return "";

        Map<Integer, String> map = new HashMap<>();
        map.put(1,    "I" );
        map.put(4,    "IV");
        map.put(5,    "V" );
        map.put(9,    "IX");
        map.put(10,   "X" );
        map.put(40,   "XL");
        map.put(50,   "L" );
        map.put(90,   "XC");
        map.put(100,  "C" );
        map.put(400,  "CD");
        map.put(500,  "D" );
        map.put(900,  "CM");
        map.put(1000, "M" );
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        int index;
        StringBuffer sb = new StringBuffer();
        while (num > 0) {
            index = values.length - 1;
            while (index >= 0 && num < values[index]) {
                index--;
            }
            num -= values[index];
            sb.append(map.get(values[index]));
        }

        return sb.toString();
    }

}

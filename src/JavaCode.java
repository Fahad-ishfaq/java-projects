import modal.Whois;

import java.util.*;

public class JavaCode {

    public static final String PATTERN_COMPRESSED_ARIN_NET_RANGE = "\\(\\S+\\) \\S+ - \\S+";

    public static void minMax(List<Integer> arr) {
        long min = Long.MAX_VALUE;
        System.out.println(min);

        long max = Long.MIN_VALUE;
        System.out.println(max);

        for (int i = 0; i < arr.size(); i ++) {
            long oneSum = 0;
            for (int j = i; j < arr.size() -1 + i; j ++) {
                int k = j;
                if (j >= arr.size()) {
                    k = j - arr.size() ;
                }
                oneSum += arr.get(k);
            }
            if (oneSum < min) {
                min = oneSum;
            }
            if (oneSum > max) {
                max = oneSum;
            }
        }
        System.out.println(min + " " + max);
    }

    public static String timeConversion(String s) {
        // Write your code here
        String[] splitString = s.split(":");
        int hours = Integer.parseInt(splitString[0]);
        String hourString = splitString[0];
        if (s.endsWith("PM")) {
            if (hours < 12) {
                hours += 12;
                hourString = String.valueOf(hours);
            }
        } else if (s.endsWith("AM")) {
            if (hours == 12) {
                hourString = "00";
            }
        }
        splitString[0] = hourString;
        String newString = String.join(":", splitString);
        newString = newString.replace("AM", "");
        newString = newString.replace("PM", "");
        return newString;

    }

    public static void main(String[] args) {
        System.out.println("run");
        minMax(List.of(new Integer[]{426980153, 354802167, 142980735, 968217435, 734892650}));
    }
}



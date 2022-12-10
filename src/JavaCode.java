import modal.Whois;
import modal.WhoisChild;

import java.util.*;
import java.util.stream.Collectors;

public class JavaCode {

    public static final String PATTERN_COMPRESSED_ARIN_NET_RANGE = "\\(\\S+\\) \\S+ - \\S+";

    public static void minMax(List<Integer> arr) {
        long min = Long.MAX_VALUE;
        System.out.println(min);

        long max = Long.MIN_VALUE;
        System.out.println(max);

        for (int i = 0; i < arr.size(); i++) {
            long oneSum = 0;
            for (int j = i; j < arr.size() - 1 + i; j++) {
                int k = j;
                if (j >= arr.size()) {
                    k = j - arr.size();
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

    public static int findMedian(List<Integer> arr) {
        int center = arr.size() / 2;
        List<Integer> newarr = arr.stream().sorted().collect(Collectors.toList());
        return newarr.get(center);

    }

    public static int lonelyinteger(List<Integer> a) {
        int unique = 0;
        Map<Integer, Long> counting = a.stream().collect(Collectors.groupingBy(integer -> integer, Collectors.counting()));
        for (int key : counting.keySet()) {
            if (counting.get(key) == 1) {
                unique = key;
            }
        }
        return unique;
    }


    public static int diagonalDifference(List<List<Integer>> arr) {
        Integer leftToRight = 0;
        Integer rightToLeft = 0;
        int matrixLen = arr.size();
        int i = 0;
        int j = matrixLen - 1;
        for (List<Integer> integerList : arr) {
            leftToRight = leftToRight + integerList.get(i);
            rightToLeft += integerList.get(j);
            i++;
            j--;
        }

        return Math.abs(leftToRight - rightToLeft);
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int[] frequencyArray = new int[101];
        List<Integer> sortedArray = new ArrayList<>(100);
        for (Integer integer : arr) {
            frequencyArray[integer] = frequencyArray[integer] + 1;
        }
        for (int number = 0; number < 100; number++) {
            sortedArray.add(frequencyArray[number]);
        }
        return sortedArray;
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int sum = 0;
        int n = matrix.size();
        for (int i = 0; i < matrix.size() / 2; i++) {
            for (int j = 0; j < matrix.size() / 2; j++) {
                sum += getLargest(new Integer[]{matrix.get(i).get(j), matrix.get(i).get(n - j - 1),
                        matrix.get(n - i - 1).get(j), matrix.get(n - i - 1).get(n - j - 1)});
            }
        }
        return sum;
    }

    public static int getLargest(Integer[] a) {
        List<Integer> list = Arrays.asList(a);
        Collections.sort(list);

        int element = list.get(list.size() - 1);
        return element;
    }

    public static void preOrder(Node root) {
        System.out.print(root.data + " ");
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }

    }

    public static void noPrefix(List<String> words) {
        // Write your code here
        boolean good = true;
        String badString = "";
        for (int i = 0; i < words.size(); i++) {
            String newBadString = "";
            String firstSting = words.get(i);
            for (int j = 0; j < words.size(); j++) {
                String secondString = words.get(j);
                if (i == j || j < i) {
                    continue;
                }
                if (secondString.startsWith(firstSting)) {
                    good = false;
                    newBadString = secondString;
                    break;
                }
            }
            if (newBadString.length() > badString.length() || (words.indexOf(newBadString) >= 0 && words.indexOf(newBadString) < words.indexOf(badString))) {
                badString = newBadString;
            }
        }
        if (good) {
            System.out.println("GOOD SET");
        } else {
            System.out.println("BAD SET");
            System.out.println(badString);
        }
    }

    void decode(String s, Node root) {
//        Huffman coding
        Node tempNode = root;
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals("0")) {
                tempNode = tempNode.left;
            } else {
                tempNode = tempNode.right;
            }

            if (tempNode.left == null && tempNode.right == null) {
                System.out.print(tempNode.data);
                tempNode = root;
            }
        }
    }

    public static final int factorial(int number) {
        int i, fact = 1;
        for (i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static int countTeams(List<Integer> skills, int minPlayers, int minLevel, int maxLevel) {
        List<Integer> singleList = new ArrayList<>();
        List<Integer> newList = skills.stream().map(integer -> {
            if (integer >= minLevel && integer <= maxLevel && !singleList.contains(integer)) {
                singleList.add(integer);
                return integer;
            } else {
                return null;
            }
        }).filter(x -> x != null).collect(Collectors.toList());
        System.out.println(Arrays.toString(newList.toArray()));
        int allFactorial = factorial(newList.size());

        System.out.println(allFactorial);
        int combination = 0;
        for (int i = minPlayers; i <= newList.size(); i++) {
            int minFactorial = factorial(i);
            int remaining = factorial(newList.size() - i);
            combination += allFactorial / (minFactorial * remaining);
        }
        return combination;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Size = nums1.length;
        int num2Size = nums2.length;
        int[] combinedArray = new int[num1Size + num2Size];

        for (int i = 0; i < num1Size; i++)  {
            combinedArray[i] = nums1[i];
        }
        for (int i = 0; i < num2Size; i++)  {
            combinedArray[num1Size +i] = nums2[i];
        }
        combinedArray = Arrays.stream(combinedArray).sorted().toArray();
        double mean = 0;
        if (combinedArray.length % 2 != 0) {
            mean = combinedArray[combinedArray.length / 2];
        } else {
            mean = (double) (combinedArray[(combinedArray.length / 2) - 1] + combinedArray[(combinedArray.length / 2)]) / 2;

        }
        return mean;
    }


    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {0,0,0,0,0}, new int[]{-1,0,0,0,0,0,1}));
    }
}

class Node {
    int data;
    Node left;
    Node right;
}



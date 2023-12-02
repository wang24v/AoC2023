import java.io.*;
import java.util.*;

public class Solution {
    private static int findCalibration(String line) {

        int first, last;
        first = last = -1;
        int i = 0;
        Map<String, Integer> digitStrings = new HashMap<>();
        digitStrings.put("one", 1);
        digitStrings.put("two", 2);
        digitStrings.put("three", 3);
        digitStrings.put("four", 4);
        digitStrings.put("five", 5);
        digitStrings.put("six", 6);
        digitStrings.put("seven", 7);
        digitStrings.put("eight", 8);
        digitStrings.put("nine", 9);

        while (last == -1) {
            String three = (i + 3 <= line.length()) ? line.substring(i, i + 3) : "";
            String four = (i + 4 <= line.length()) ? line.substring(i, i + 4) : "";
            String five = (i + 5 <= line.length()) ? line.substring(i, i + 5) : "";
            boolean isDigit = line.charAt(i) >= 48 && line.charAt(i) <= 57;
            if (isDigit) {
                last = first = line.charAt(i) - 48;
            } else if (digitStrings.containsKey(three)) {
                last = first = digitStrings.get(three);
            } else if (digitStrings.containsKey(four)) {
                last = first = digitStrings.get(four);
            } else if (digitStrings.containsKey(five)) {
                last = first = digitStrings.get(five);
            }
            i++;
        }

        while (i < line.length()) {
            String three = (i + 3 <= line.length()) ? line.substring(i, i + 3) : "";
            String four = (i + 4 <= line.length()) ? line.substring(i, i + 4) : "";
            String five = (i + 5 <= line.length()) ? line.substring(i, i + 5) : "";
            boolean isDigit = line.charAt(i) >= 48 && line.charAt(i) <= 57;
            if (isDigit) {
                last = line.charAt(i) - 48;
            } else if (digitStrings.containsKey(three)) {
                last = digitStrings.get(three);
            } else if (digitStrings.containsKey(four)) {
                last = digitStrings.get(four);
            } else if (digitStrings.containsKey(five)) {
                last = digitStrings.get(five);
            }
            i++;
        }

        return 10 * first + last;
    }
    public static int sumCalibration(List<String> lines) {
        int rtn = 0;
        for (String line : lines) {
            rtn += Solution.findCalibration(line);
            System.out.println(Solution.findCalibration(line));
        }
        return rtn;
    }
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\vince\\IdeaProjects\\AoC2023\\src\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<String> input = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            input.add(st);
        }
        System.out.println(Solution.sumCalibration(input));

    }
}
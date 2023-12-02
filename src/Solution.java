import java.io.*;
import java.util.*;

public class Solution {
    public static int power(String line) {
        String withoutHeader = line.substring(line.indexOf(':') + 2);
        String[] games = withoutHeader.split("; ");
        int redCount = 0;
        int greenCount = 0;
        int blueCount = 0;
        for (String game : games) {
            String[] cubes = game.split(", ");
            for (String cube : cubes) {
                String[] cubeCount = cube.split(" ");
                int cubeNum = Integer.parseInt(cubeCount[0]);
                if (cubeCount[1].equals("red")) {
                    redCount = Math.max(redCount, cubeNum);
                } else if (cubeCount[1].equals("green")) {
                    greenCount = Math.max(greenCount, cubeNum);
                } else {
                    blueCount = Math.max(blueCount, cubeNum);
                }
            }
        }
        return redCount * greenCount * blueCount;
    }

    public static int sumPowers(List<String> lines) {
        int rtn = 0;
        for (String line : lines) {
            rtn += Solution.power(line);
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
        FileWriter fw = new FileWriter("C:\\Users\\vince\\IdeaProjects\\AoC2023\\src\\output.txt");
        fw.write(Solution.sumPowers(input) + "\n");
        fw.close();
    }
}
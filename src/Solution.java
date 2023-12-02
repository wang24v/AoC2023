import java.io.*;
import java.util.*;

public class Solution {
    public static int isPossible(String line) {
        System.out.println(line);
        int id = Integer.parseInt(line.substring(5, line.indexOf(':')));
        String withoutHeader = line.substring(line.indexOf(':') + 2);
        String[] games = withoutHeader.split("; ");
        for (String game : games) {
            String[] cubes = game.split(", ");
            for (String cube : cubes) {
                String[] cubeCount = cube.split(" ");
                if (cubeCount[1].equals("red")) {
                    if (Integer.parseInt(cubeCount[0]) > 12) {
                        return 0;
                    }
                } else if (cubeCount[1].equals("green")) {
                    if (Integer.parseInt(cubeCount[0]) > 13) {
                        return 0;
                    }
                } else {
                    if (Integer.parseInt(cubeCount[0]) > 14) {
                        return 0;
                    }
                }
            }
        }
        return id;
    }

    public static int sumIds(List<String> lines) {
        int rtn = 0;
        for (String line : lines) {
            rtn += Solution.isPossible(line);
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
        fw.write(Solution.sumIds(input) + "\n");
        fw.close();
    }
}
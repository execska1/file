package com.codecool.chessopen;

import java.io.*;
import java.util.*;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName){
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> players = collectNamesAndPointsFromFile(fileName);

        players.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> result.add(entry.getKey()));
        return result;
    }

    private HashMap<String, Integer> collectNamesAndPointsFromFile(String fileName) {
        HashMap<String, Integer> result = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                Scanner line = new Scanner(scanner.nextLine());
                line.useDelimiter(",");
                String name = line.next();
                int points = 0;

                while (line.hasNext()) {
                    points += line.nextInt();
                }

                result.put(name, points);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return result;
    }

}

package io;

import domain.City;
import domain.Route;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphFileReader {

    public List<Route> readNodesFromFile(String fileName) {
        List<Route> allRoutes = new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(fileName), StandardCharsets.UTF_8));) {

                String line;
                String[]  words, costs;
                int cost;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    words = line.split(",");
                    costs = words[9].split("[.]");
                    cost = Integer.valueOf(costs[0]) * 100 + Integer.valueOf(costs[1]);
                    allRoutes.add(Route.builder()
                            .from(new City(words[2]))
                            .to(new City(words[4]))
                            .cost(cost)
                            .build()
                    );
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("Size: " + allRoutes.size());
        return allRoutes;
    }
}

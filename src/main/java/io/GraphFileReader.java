package io;

import domain.City;
import domain.Route;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class GraphFileReader {

    public Set readNodesFromFile(String fileName) {
        Set<Route> allRoutes = new HashSet<>();
        try {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(fileName), StandardCharsets.UTF_8));) {

                String line;
                String[]  words;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    words = line.split(",");
                    allRoutes.add(Route.builder()
                            .from(new City(words[2]))
                            .to(new City(words[4]))
                            .cost(Double.valueOf(words[9]))
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

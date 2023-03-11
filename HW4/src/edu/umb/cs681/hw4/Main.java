package edu.umb.cs681.hw4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        var path = Paths.get("src/edu/umb/cs681/hw4/Data/bos-housing.csv");
        System.out.println(path);

        System.out.println("hi");

        try (Stream<String> lines = Files.lines(path)) {

            List<List<String>> data = lines.skip(1).map(line -> {
                return Stream.of(line.split(",")).map(value -> value.substring(0, value.length()))
                        .collect(Collectors.toList());
            }).collect(Collectors.toList());

            // System.out.println("\nEntire data: \n" + data);
            DataProcessing_1.dataprocessing1(data);
            DataProcessing_2.dataprocessing2(data);
            DataProcessing_3.dataprocessing3(data);
            DataProcessing_4.dataprocessing4(data);
        } catch (IOException ex) {
            System.out.println("Exception");
            // do something or re-throw...
        }
    }
}

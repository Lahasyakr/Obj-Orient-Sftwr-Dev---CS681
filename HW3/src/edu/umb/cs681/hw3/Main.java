package edu.umb.cs681.hw3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.umb.cs681.hw3.Observer.CandleStickObserver;
import edu.umb.cs681.hw3.Observer.DJIAWkSummaryObservable;
import edu.umb.cs681.hw3.Summary.DSummary;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        var path = Paths.get("src/edu/umb/cs681/hw3/data/data.csv");
        System.out.println(path);

        try (Stream<String> lines = Files.lines(path)) {
            List<List<String>> csv = lines.map(line -> {
                return Stream.of(line.split(",")).map(value -> value.substring(0, value.length()))
                        .collect(Collectors.toList());
            }).collect(Collectors.toList());
            System.out.println(csv);
            

            DJIAWkSummaryObservable obj = new DJIAWkSummaryObservable();
            CandleStickObserver candleStickObserver = new CandleStickObserver();
            obj.addObserver(candleStickObserver);

            

            csv.forEach((item) -> {
                if (item.get(0) != "Date") {
                    try {
                        DSummary d = new DSummary(Double.parseDouble(item.get(1)), Double.parseDouble(item.get(4)),
                                Double.parseDouble(item.get(2)), Double.parseDouble(item.get(3)));
                        obj.addSummary(d);
                    } catch (NumberFormatException ignored) {
                        //System.out.println("Error!!, please try again later");
                    }

                }
            });
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }
}

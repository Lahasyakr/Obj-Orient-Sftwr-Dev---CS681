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
            List<List<Double>> csv = lines.skip(1).map(line -> {
                return Stream.of(line.split(",")).skip(1).map(value -> Double.parseDouble(value))
                        .collect(Collectors.toList());
            }).collect(Collectors.toList());
            System.out.println(csv);

            DJIAWkSummaryObservable obj = new DJIAWkSummaryObservable();
            CandleStickObserver candleStickObserver = new CandleStickObserver();
            obj.addObserver(candleStickObserver);

            csv.stream().forEach((item) -> {
                try {
                    DSummary d = new DSummary(item.get(0), item.get(3), item.get(1), item.get(2));
                    obj.addSummary(d);
                } catch (NumberFormatException ignored) {

                }

            });
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }
}

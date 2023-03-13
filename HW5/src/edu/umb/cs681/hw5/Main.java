package edu.umb.cs681.hw5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        var path = Paths.get("src/edu/umb/cs681/hw5/Data/bos-housing.csv");
        System.out.println(path);

        System.out.println("hi");

        try (Stream<String> lines = Files.lines(path)) {

            List<List<String>> data = lines.skip(1).map(line -> {
                return Stream.of(line.split(",")).map(value -> value.substring(0, value.length()))
                        .collect(Collectors.toList());
            }).collect(Collectors.toList());

            RunnableDataProcessing_1 run1 = new RunnableDataProcessing_1(data);
            RunnableDataProcessing_2 run2 = new RunnableDataProcessing_2(data);
            RunnableDataProcessing_3 run3 = new RunnableDataProcessing_3(data);
            RunnableDataProcessing_4 run4 = new RunnableDataProcessing_4(data);

            Thread t1 = new Thread(run1);
            Thread t2 = new Thread(run2);
            Thread t3 = new Thread(run3);
            Thread t4 = new Thread(run4);

            t1.start();
            t2.start();
            t3.start();
            t4.start();
            try {
                t1.join();
                t2.join();
                t3.join();
                t4.join();
            } catch (InterruptedException e) {
            }
            run1.getResults();
            run2.getResults();
            run3.getResults();
            run4.getResults();

        } catch (IOException ex) {
            System.out.println("Exception");
            // do something or re-throw...
        }
    }
}

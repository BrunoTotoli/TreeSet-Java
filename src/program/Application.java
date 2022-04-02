package program;

import entities.Log;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Application {
    public static void main(String[] args) {
        Path p1 = Paths.get("in.txt");
        if (Files.notExists(p1))
            createFile(p1);
        write(p1);
        Set<Log> setLog = new TreeSet<Log>();
        setLog = readAndSplit(p1, setLog);
        for (Log a : setLog) {
            System.out.println(a);
        }
        System.out.println("Size: " + setLog.size());


    }


    static void createFile(Path p1) {
        try {
            Files.createFile(p1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void write(Path p1) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(p1.toFile()))) {
            bw.write("amanda 2018-08-26T20:45:08Z\n" +
                    "alex86 2018-08-26T21:49:37Z\n" +
                    "bobbrown 2018-08-27T03:19:13Z\n" +
                    "amanda 2018-08-27T08:11:00Z\n" +
                    "jeniffer3 2018-08-27T09:19:24Z\n" +
                    "alex86 2018-08-27T22:39:52Z\n" +
                    "amanda 2018-08-28T07:42:19Z");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Set<Log> readAndSplit(Path p1, Set set) {
        Set<Log> treeSet = new TreeSet<Log>();
        try (BufferedReader bw = new BufferedReader(new FileReader(p1.toFile()))) {
            String line = bw.readLine();
            while (line != null) {
                String inputSplit[] = line.split(" ");
                treeSet.add(new Log(inputSplit[0], Date.from(Instant.parse(inputSplit[1]))));
                line = bw.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return treeSet;
    }
}

package pl.jezior.cleancode.playground;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Playground {
    public String hello() {
        return "World!";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Files.readAllLines(Paths.get(Playground.class.getClassLoader().getResource("sherlock.txt").getPath()))
                .stream()
                .flatMap(l -> Arrays.stream(l.split("")).filter(s -> s.length() > 0).map(s->s.charAt(0)))
                .filter(Playground::isUpper)
                .count());
    }

    private static boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }
}

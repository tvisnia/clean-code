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
        System.out.println(new Playground().countUppercase("sherlock.txt"));
    }

    public long countUppercase(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(getClass().getClassLoader().getResource(fileName).getPath()))
                .stream()
                .flatMap(l -> Arrays.stream(l.split("")).filter(s -> s.length() > 0).map(s->s.charAt(0)))
                .filter(this::isUpper)
                .count();
    }

    public boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }
}

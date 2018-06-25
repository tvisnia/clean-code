package pl.jezior.cleancode.playground;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Playground {
    public String hello() {
        return "World!";
    }

    public boolean isUpperCase(@NotNull Character ch) {
        return Character.isUpperCase(ch);
    }

    public static void main(String[] args) throws IOException {
        Playground playground = new Playground();
        CharacterCounter characterCounter = new CharacterCounter();
        Stream<String> lines = playground.readFileAsLines("sherlock.txt");
        Predicate<Character> predicate = Character::isUpperCase;
        long count = characterCounter.count(lines, predicate);
        System.out.println(count);

    }

    private Stream<String> readFileAsLines(String fileName) throws IOException {
        return Files.lines(Paths.get(Playground.class.getClassLoader()
                .getResource(fileName).getPath()));
    }
}

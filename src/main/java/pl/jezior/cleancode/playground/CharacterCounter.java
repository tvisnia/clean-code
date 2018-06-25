package pl.jezior.cleancode.playground;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CharacterCounter {
    public long count(Stream<String> lines, Predicate<Character> predicate) {
        return lines
                .flatMap(line -> Arrays.stream(line.split(""))
                        .filter(this::isNotEmpty)
                        .map(this::firstCharacter))
                .filter(predicate)
                .count();
    }

    private char firstCharacter(String s) {
        return s.charAt(0);
    }

    private boolean isNotEmpty(String s) {
        return s.length() != 0;
    }
}

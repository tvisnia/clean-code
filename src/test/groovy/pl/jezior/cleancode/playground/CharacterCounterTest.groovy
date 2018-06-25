package pl.jezior.cleancode.playground

import spock.lang.Specification
import spock.lang.Unroll

import java.util.function.Predicate


class CharacterCounterTest extends Specification {

    def underTest = new CharacterCounter()

    @SuppressWarnings("GroovyAssignabilityCheck")
    @Unroll
    def "should count"() {
        when:
        def count = underTest.count(lines, predicate as Predicate)

        then:
        count == expectedCount

        where:
        expectedCount | predicate     | lines
        0             | isUpperCase() | [].stream()
        4             | isUpperCase() | ["AbC", "CaD"].stream()
        2             | isLowerCase() | ["AbC", "CaD"].stream()


    }

    private static Closure<Boolean> isLowerCase() {
        { it -> Character.isLowerCase(it as Character) }
    }

    private static Closure<Boolean> isUpperCase() {
        { it -> Character.isUpperCase(it as Character) }
    }

}

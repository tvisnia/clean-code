package pl.jezior.cleancode.playground

import spock.lang.Specification

class PlaygroundTest extends Specification {
    def shouldGreet() {
        given:
        def underTest = new Playground()

        when:
        def response = underTest.hello()

        then:
        response == "World!"
    }
}

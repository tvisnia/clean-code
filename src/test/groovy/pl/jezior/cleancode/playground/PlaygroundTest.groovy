package pl.jezior.cleancode.playground

import spock.lang.Specification
import spock.lang.Unroll

class PlaygroundTest extends Specification {

    def underTest = new Playground()

    def shouldGreet() {
        given: "The instance is created"


        when:
        def response = underTest.hello()

        then:
        response == "World!"
    }

    @Unroll
    def "should determine whether #character letter is uppercase #result"() {
        given: "The instance is created"

        when:
        def isUppercase = underTest.isUpperCase(character as Character)

        then:
        isUppercase == result

        where:
        character | result
        'A'       | true
        'a'       | false
        '1'       | false
        '_'       | false
        "Ą"       | true
    }
}

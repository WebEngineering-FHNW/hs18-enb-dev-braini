package webec

import grails.testing.web.taglib.TagLibUnitTest
import spock.lang.Specification

class CustomTestTagLibSpec extends Specification implements TagLibUnitTest<CustomTestTagLib> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}

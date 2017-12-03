package in.ankushs.linode4j.util

import in.ankushs.BaseSpec

/**
 * Created by ankushsharma on 02/12/17.
 */
class StringsSpec extends BaseSpec{

    def "Does String have text?"(){

        when:
            def result = Strings.hasText(str)

        then:
            result == expectedResult

        where:
            str |  expectedResult
            "A" | true
            null | false
            " "  | false
            ""  | false
            " trim " | true
    }
}

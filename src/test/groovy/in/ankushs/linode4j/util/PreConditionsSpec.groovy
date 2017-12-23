package in.ankushs.linode4j.util

import in.ankushs.BaseSpec

/**
 * Created by ankushsharma on 03/12/17.
 */
class PreConditionsSpec extends BaseSpec{

    def "throw exception when null is passed"(){
        when :
            Assert.notNull(null , "this shouldn't be null")

        then :
            thrown(IllegalArgumentException)
    }

    def "throw exception when a string is null or empty(post trimming)"(){
        when :
            Assert.notEmptyString(Strings.EMPTY + "  ", "string cannot be null or empty")

        then :
            thrown(IllegalArgumentException)
    }

    def "throw exception when a negative int is passed"(){
        when :
            Assert.isPositive(-1 , "int cannot be 0 or negative")

        then :
            thrown(IllegalArgumentException)
    }

}

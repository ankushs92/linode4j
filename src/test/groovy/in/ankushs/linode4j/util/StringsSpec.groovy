package in.ankushs.linode4j.util

import in.ankushs.BaseSpec

/**
 * Created by ankushsharma on 02/12/17.
 */
class StringsSpec extends BaseSpec{

    def "throw exception when null is passed"(){
        when :
            PreConditions.notNull(null , "this shouldn't be null")

        then :
            thrown(IllegalArgumentException)
    }
}

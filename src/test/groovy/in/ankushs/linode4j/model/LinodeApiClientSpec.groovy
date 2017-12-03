package in.ankushs.linode4j.model

import in.ankushs.BaseSpec
import in.ankushs.linode4j.api.LinodeApiClient
import in.ankushs.linode4j.util.Strings

/**
 * Created by ankushsharma on 03/12/17.
 */
class LinodeApiClientSpec extends BaseSpec {

    def "pass null token into constructor. exception will be thrown"(){
        when :
            new LinodeApiClient(null)

        then :
            thrown(IllegalArgumentException)
    }

    def "pass empty token into constructor. exception will be thrown"(){
        when :
            new LinodeApiClient(Strings.EMPTY)

        then :
            thrown(IllegalArgumentException)
    }

}

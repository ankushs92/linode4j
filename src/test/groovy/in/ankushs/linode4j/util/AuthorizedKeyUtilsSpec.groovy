package in.ankushs.linode4j.util

import in.ankushs.BaseSpec
import in.ankushs.linode4j.exception.LinodeException

/**
 * Created by ankushsharma on 03/12/17.
 */
class AuthorizedKeyUtilsSpec extends BaseSpec{

    def "pass in a key that starts with any type that is not an AuthorizedKeysUtils.ACCEPTABLE_TYPES. throw an exception in this case"(){

        given :
            Set<String> sshKeys = ["invalid", "ssh-weird-string"]

        when :
            AuthorizedKeysUtils.validate(sshKeys)

        then :
            thrown(LinodeException)
    }
}

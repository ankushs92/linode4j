package in.ankushs

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import spock.lang.Specification

/**
 * Created by ankushsharma on 02/12/17.
 */
class BaseSpec extends Specification {

    protected ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

}

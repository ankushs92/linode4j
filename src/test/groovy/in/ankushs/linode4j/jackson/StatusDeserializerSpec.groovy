package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.LinodeStatus

/**
 * Created by ankushsharma on 03/12/17.
 */
class StatusDeserializerSpec extends BaseSpec{

    def "Testing out various enum values "(){

        given :
            def json = new JsonBuilder([status: status ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new StatusDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
           status                         |  expectedResult
            'offline'                     |  LinodeStatus.OFFLINE
            'booting'                     |  LinodeStatus.BOOTING
            'random_string'               |  LinodeStatus.UNKNOWN
    }

}

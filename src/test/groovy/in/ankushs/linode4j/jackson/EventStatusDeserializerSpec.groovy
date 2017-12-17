package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.EventStatus

/**
 * Created by ankushsharma on 03/12/17.
 */
class EventStatusDeserializerSpec extends BaseSpec{

    def "Testing out various enum values "(){
        given :
            def json = new JsonBuilder([eventStatus: eventStatus ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new EventStatusDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            eventStatus                 |  expectedResult
            'failed'                    |  EventStatus.FAILED
            'notification'              |  EventStatus.NOTIFICATION
            'random_string'             |  EventStatus.UNKNOWN
            '   '                       |  EventStatus.UNKNOWN
    }

}

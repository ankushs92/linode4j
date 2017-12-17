package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.NotificationType

/**
 * Created by ankushsharma on 03/12/17.
 */
class NotificationTypeDeserializerSpec extends BaseSpec {

    def "Testing out various enum values "(){

        given :
            def json = new JsonBuilder([notification: notification ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new NotificationTypeDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            notification                  |  expectedResult
            'important_ticket'            |  NotificationType.IMPORTANT_TICKET
            'abuse_ticket'                |  NotificationType.ABUSE_TICKET
            'outage'                      |  NotificationType.OUTAGE
            'random_string'               |  NotificationType.UNKNOWN
             ''                           |  NotificationType.UNKNOWN

    }


}

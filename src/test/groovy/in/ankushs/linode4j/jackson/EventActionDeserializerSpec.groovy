package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.EventAction

/**
 * Created by ankushsharma on 03/12/17.
 */
class EventActionDeserializerSpec extends BaseSpec{

    def "Testing out various enum values "(){
        given :
            def json = new JsonBuilder([event: event ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new EventActionDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            event                           | expectedResult
                'linode_boot'               |  EventAction.LINODE_BOOT
                'disk_create'               |  EventAction.DISK_CREATE
                'domain_create'             |  EventAction.DOMAIN_CREATE
                'stackscript_create'        |  EventAction.STACKSCRIPT_CREATE
                'random_string'             |  EventAction.UNKNOWN

        }

}

package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.NotificationType
import in.ankushs.linode4j.model.enums.OAuthClientStatus

/**
 * Created by ankushsharma on 03/12/17.
 */
class OAuthClientStatusDeserializerSpec extends BaseSpec{

    def "Testing out various enum values "(){

        given :
            def json = new JsonBuilder([status: status ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new OAuthClientStatusDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            status                  |  expectedResult
            'active'                |  OAuthClientStatus.ACTIVE
            'suspended'             |  OAuthClientStatus.SUSPENDED
            'random_string'         |  OAuthClientStatus.UNKNOWN
    }

}

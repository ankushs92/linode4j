package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.OAuthScope

/**
 * Created by ankushsharma on 08/01/18.
 */
class OAuthScopeDeserializerSpec extends BaseSpec{

    def "Testing out various enum values "(){

        given :
            def json = new JsonBuilder([scope: scope ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new OAuthScopeDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            scope                         |  expectedResult
            'linodes:view'                |  OAuthScope.LINODE_VIEW
            'tickets:delete'              |  OAuthScope.TICKET_DELETE
            'ips:modify'                  |  OAuthScope.IP_MODIFY
            ''                            |  OAuthScope.UNKNOWN

    }

}

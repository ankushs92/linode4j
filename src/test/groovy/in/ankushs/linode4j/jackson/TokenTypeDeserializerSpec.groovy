package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.Plan
import in.ankushs.linode4j.model.enums.TokenType

/**
 * Created by ankushsharma on 08/01/18.
 */
class TokenTypeDeserializerSpec extends BaseSpec {

    def "Testing out various enum values "(){

        given :
            def json = new JsonBuilder([tokenType: tokenType ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new TokenTypeDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
             result  == expectedResult

        where:
        tokenType                                       |  expectedResult
            ''                                          |  TokenType.UNKNOWN
            'client_token'                              |  TokenType.CLIENT_TOKEN
            'personal_access_token'                     |  TokenType.PERSONAL_ACCESS_TOKEN

    }

}

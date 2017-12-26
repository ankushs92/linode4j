package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.InvoiceItemType
import in.ankushs.linode4j.model.enums.LishAuthMethod

/**
 * Created by ankushsharma on 24/12/17.
 */
class LishAuthMethodDeserializerSpec extends BaseSpec{

    def "Testing out various enum values "(){

        given :
            def json = new JsonBuilder([authMethod: authMethod ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new LishAuthMethodDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            authMethod                   |  expectedResult
            'password_keys'              |  LishAuthMethod.PASSWORD_KEYS
            'disabled'                   |  LishAuthMethod.DISABLED
            'keys_only'                  |  LishAuthMethod.KEYS_ONLY
            ' '                          |  LishAuthMethod.UNKNOWN

    }

}

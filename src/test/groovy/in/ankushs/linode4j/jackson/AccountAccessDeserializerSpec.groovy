package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.GrantPermission

/**
 * Created by ankushsharma on 24/12/17.
 */
class AccountAccessDeserializerSpec extends BaseSpec{

    def "Testing out various enum values "(){
        given :
            def json = new JsonBuilder([accAccess: accAccess ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new GrantPermissionDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

            where:
            accAccess             | expectedResult
            'read_only'           |  GrantPermission.READ_ONLY
            'read_write'          |  GrantPermission.READ_WRITE
            'null'                |  GrantPermission.NO_ACCESS
            ''                    |  GrantPermission.UNKNOWN

    }

}

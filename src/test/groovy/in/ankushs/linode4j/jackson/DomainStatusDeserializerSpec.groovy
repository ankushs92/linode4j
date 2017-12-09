package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.DomainStatus

/**
 * Created by ankushsharma on 07/12/17.
 */
class DomainStatusDeserializerSpec extends BaseSpec{

    def "Testing out various enum values "(){
        given :
            def json = new JsonBuilder([ds: ds ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new DomainStatusDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            ds                       | expectedResult
            'active'                 |  DomainStatus.ACTIVE
            'disabled'               |  DomainStatus.DISABLED
            'edit_mode'              |  DomainStatus.EDIT_MODE
            'random_string'          |  DomainStatus.UNKNOWN

    }

}

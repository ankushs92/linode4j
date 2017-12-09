package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.DomainType

/**
 * Created by ankushsharma on 07/12/17.
 */
class DomainTypeDeserializerSpec extends BaseSpec {

    def "Testing out various enum values "(){
        given :
            def json = new JsonBuilder([dt: dt ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new DomainTypeDeserializer().deserialize(jsonParser,deserializationCtx)

        then :
            result  == expectedResult

        where:
            dt                          |  expectedResult
            'slave'                     |  DomainType.SLAVE
            'master'                    |  DomainType.MASTER
            'random_string'             |  DomainType.UNKNOWN
    }


}

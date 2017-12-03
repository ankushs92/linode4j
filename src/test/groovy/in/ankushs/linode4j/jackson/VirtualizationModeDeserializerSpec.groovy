package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.VirtualizationMode

/**
 * Created by ankushsharma on 03/12/17.
 */
class VirtualizationModeDeserializerSpec extends BaseSpec {

    def "Testing out various enum values "(){

        given :
            def json = new JsonBuilder([vm: vm ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new VirtualizationModeDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

            where:
            vm                         |  expectedResult
            'fullvirt'                 |  VirtualizationMode.FULL_VIRTUALIZATION
            'paravirt'                 |  VirtualizationMode.PARA_VIRTUALIZATION
            'random_string'            |  VirtualizationMode.UNKNOWN
    }

}

package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.FileSystem
import in.ankushs.linode4j.model.enums.HyperVisor

/**
 * Created by ankushsharma on 03/12/17.
 */
class HyperVisorDeserializerSpec extends BaseSpec {

    def "Testing out various enum values "(){
        given :
            def json = new JsonBuilder([fs: fs ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new HyperVisorDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            fs                 |  expectedResult
            'xen'              |  HyperVisor.XEN
            'kvm'              |  HyperVisor.KVM
            'random_string'    |  HyperVisor.UNKNOWN
        }

}

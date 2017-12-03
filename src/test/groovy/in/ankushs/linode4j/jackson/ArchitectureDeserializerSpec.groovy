package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.Architecture

/**
 * Created by ankushsharma on 03/12/17.
 */
class ArchitectureDeserializerSpec extends BaseSpec {

    def "Testing out various enum values "(){
        given :
            def json = new JsonBuilder([architecture: architecture ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new ArchitectureDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            architecture          | expectedResult
            'i386'                |  Architecture.i386
            'x86_64'              |  Architecture.X86_64
            'random_string'       |  Architecture.UNKNOWN

    }

}

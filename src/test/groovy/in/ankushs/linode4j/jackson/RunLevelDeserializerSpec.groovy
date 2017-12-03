package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.RunLevel

/**
 * Created by ankushsharma on 03/12/17.
 */
class RunLevelDeserializerSpec extends BaseSpec{

    def "Testing out various enum values "(){

        given :
            def json = new JsonBuilder([runLevel: runLevel ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new RunLevelDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

            where:
            runLevel                  |  expectedResult
            'binbash'                 |  RunLevel.BINBASH
            'default'                 |  RunLevel.DEFAULT
            'random_string'           |  RunLevel.UNKNOWN
        }

}

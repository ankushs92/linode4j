package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.Plan

/**
 * Created by ankushsharma on 03/12/17.
 */
class PlanDeserializerSpec extends BaseSpec {

    def "Testing out various enum values "(){

        given :
            def json = new JsonBuilder([plan: plan ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new PlanDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            plan                          |  expectedResult
            'standard'                    |  Plan.STANDARD
            'nanode'                      |  Plan.NANODE
            'highmem'                     |  Plan.HIGH_MEMORY
            'random_string'               |  Plan.UNKNOWN
            ''                            |  Plan.UNKNOWN

    }

}

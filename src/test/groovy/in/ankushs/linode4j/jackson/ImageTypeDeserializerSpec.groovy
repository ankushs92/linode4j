package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.ImageType

/**
 * Created by ankushsharma on 11/01/18.
 */
class ImageTypeDeserializerSpec extends BaseSpec {

    def "Testing out various enum values "(){
        given :
            def json = new JsonBuilder([imgType : imgType ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new ImageTypeDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
             imgType                 |  expectedResult
            'manual'                 |  ImageType.MANUAL
            'automatic'             |  ImageType.AUTOMATIC
             null                    |  ImageType.UNKNOWN

    }

}

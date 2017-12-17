package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.BlockStorageVolumeStatus

/**
 * Created by ankushsharma on 03/12/17.
 */
class BlockStorageVolumeStatusDeserializerSpec extends BaseSpec {


    def "Testing out various enum values "(){
        given :
            def json = new JsonBuilder([volume: volume ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new BlockStorageVolumeStatusDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            volume                        | expectedResult
                'creating'                |  BlockStorageVolumeStatus.CREATING
                'active'                  |  BlockStorageVolumeStatus.ACTIVE
                'resizing'                |  BlockStorageVolumeStatus.RESIZING
                'offline'                 |  BlockStorageVolumeStatus.OFFLINE
                'random_string'           |  BlockStorageVolumeStatus.UNKNOWN
                 ''                       |  BlockStorageVolumeStatus.UNKNOWN

    }

}

package in.ankushs.linode4j.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.jackson.deserializers.ArchitectureDeserializer
import in.ankushs.linode4j.jackson.deserializers.BlockStorageVolumeStatusDeserializer
import in.ankushs.linode4j.model.enums.Architecture
import in.ankushs.linode4j.model.enums.BlockStorageVolumeStatus

/**
 * Created by ankushsharma on 03/12/17.
 */
class BlockStorageVolumeStatusDeserializerSpec extends BaseSpec {

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

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

    }

}

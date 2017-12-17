package in.ankushs.linode4j.jackson

import groovy.json.JsonBuilder
import in.ankushs.BaseSpec
import in.ankushs.linode4j.model.enums.InvoiceItemType

/**
 * Created by ankushsharma on 03/12/17.
 */
class InvoiceItemTypeDeserializerSpec extends BaseSpec{

    def "Testing out various enum values "(){

        given :
            def json = new JsonBuilder([invoiceItem: invoiceItem ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new InvoiceItemTypeDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

        where:
            invoiceItem                  |  expectedResult
            'misc'                       |  InvoiceItemType.MISC
            'prepay'                     |  InvoiceItemType.PREPAY
            'random_string'              |  InvoiceItemType.UNKNOWN
             ' '                         |  InvoiceItemType.UNKNOWN

    }


}

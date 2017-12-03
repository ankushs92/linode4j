package in.ankushs.linode4j.util

import in.ankushs.BaseSpec

/**
 * Created by ankushsharma on 03/12/17.
 */
class JsonSpec extends BaseSpec{


    def "Convert an object to Json String"(){

        given : " Some Person object "
             def person = new Person(name : "Ankush", age : 25)

        when:
             String json = Json.toJson(person)

        then:
             json == '{"name":"Ankush","age":25}'
    }

    def "Convert a proper and valid string to Json Object"(){

        given : "A json representation of a Person object"
        def json = '{\n' +
                '  "name" : "Ankush",\n' +
                '  "age" : 24\n' +
                '}'
        when:
        def person = Json.toObject(json,Person)

        then:
        person.name == "Ankush"
        person.age == 24
    }

    def "Pass null json to method.Should throw IllegalArgumentException"(){

        when:
        Json.toJson(null)

        then :
        thrown(IllegalArgumentException)
    }

    def "Pass null object to method.Should throw IllegalArgumentException"(){

        when:
        Json.toObject("",null)

        then :
        thrown(IllegalArgumentException)
    }

    private static class Person{
        String name
        int age
    }

}

package in.ankushs.linode4j.util;

import lombok.val;

import java.util.Objects;

/**
 * Created by Ankush on 17/07/17.
 */
public class Strings {

    private Strings(){}

    public static final String EMPTY = "";

    /*
    * Returns false if the String does not have text after trimming
    * */
    public static boolean hasText(final String text){
        if(Objects.isNull(text)){
            return false;
        }
        for(val ch : text.toCharArray()){
            if(!Character.isWhitespace(ch)){
                return true;
            }
        }
        return false;
    }

    /*
    * Uses a StringBuilder to build an array of objects. The value returned in the Object's toString method is considered
    * If a null is passed in the array, it is simply ignored
    * */
    public static <T> String build(final T... array){
        PreConditions.notNull(array, "array cannot be null");
        val sb = new StringBuilder();
        for(val object : array){
            if(Objects.nonNull(object)){
                sb.append(object.toString());
            }
        }
        return sb.toString();
    }

}

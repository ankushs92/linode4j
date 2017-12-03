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
}

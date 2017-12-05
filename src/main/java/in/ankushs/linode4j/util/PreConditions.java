package in.ankushs.linode4j.util;

import java.util.Objects;

/**
 * Created by Ankush on 17/07/17.
 */
public final class PreConditions {

    private PreConditions(){}

    public static void isPositive(final int num, final String errorMsg){
        if(num < 0){
            throw new IllegalArgumentException(errorMsg);
        }
    }

    public static <T> void notNull(final T t , final String errorMsg){
        if(Objects.isNull(t)){
            throw new IllegalArgumentException(errorMsg);
        }
    }

    public static void notEmptyString(final String string, final String errorMsg){
        if(!Strings.hasText(string)){
            throw new IllegalArgumentException(errorMsg);
        }
    }

}

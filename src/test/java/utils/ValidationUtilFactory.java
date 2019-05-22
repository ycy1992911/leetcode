package utils;

import java.util.Collection;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-17
 */
public class ValidationUtilFactory {
    private ValidationUtilFactory() {}

    public static <E> boolean isNullOrEmpty(Collection<E> collection) {
        return collection == null || collection.isEmpty();
    }
}

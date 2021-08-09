package cn.tanli.test.vo;/**
 * cn.tanli.test.vo
 *
 * @author Tan.li
 * @date 2021/6/29
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *@ClassName StreamUtil
 *@Description TODO
 *@Author Tan.li
 *@Date 2021/6/29
 *@Since 1.0
 */
public class StreamUtil {

    /**
     * 指定字段去重
     * @param keyExtractor
     * @return
     */
    static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}

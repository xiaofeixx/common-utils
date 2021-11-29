package com.xiaofei.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * collection 工具类
 */
public class CollectionUtils {

    /**
     * 转 map
     * @param collection collection
     * @param key key
     * @param value value
     * @param <K> k
     * @param <V> v
     * @param <T> t
     * @return 转换结果
     */
    public static <K, V, T> Map<K, V> collectionToMap(Collection<T> collection, Function<T, K> key
            , Function<T, V> value) {
        if (Objects.isNull(collection)) {
            return Collections.emptyMap();
        }
        Map<K, V> result = new HashMap<>();
        for (T t : collection) {
            result.put(key.apply(t), value.apply(t));
        }
        return result;
    }

    /**
     * 分组
     * @param collection collection
     * @param keyMapper keyMapper
     * @param <K> k
     * @param <T> t
     * @return 转换结果
     */
    public static <K, T> Map<K, List<T>> collectionGroupBy(Collection<T> collection, Function<T, K> keyMapper) {
        if (Objects.isNull(collection)) {
            return Collections.emptyMap();
        }
        List<T> ts;
        Map<K, List<T>> result = new HashMap<>();
        for (T t : collection) {
            ts = result.get(keyMapper.apply(t));
            if (Objects.isNull(ts)) {
                ts = new ArrayList<>();
            }
            ts.add(t);
            result.put(keyMapper.apply(t), ts);
        }
        return result;
    }

    /**
     * 判断是否为空
     * @param collection collection
     * @return 判断结果
     */
    public static boolean isEmpty(Collection<?> collection) {
        return Objects.isNull(collection) || collection.isEmpty();
    }

    /**
     * 判断是否不为空
     * @param collection collection
     * @return 判断结果
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

}

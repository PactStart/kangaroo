package io.github.pactstart.biz.common.utils;

import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.Set;

public class CollectionsUtils {

    /**
     * 判断两个集合是否相等
     *
     * @param c1 集合1
     * @param c2 集合2
     * @param <T> 元素类型
     * @return 是否相等
     */
    public static <T> boolean equals(Collection<T> c1, Collection<T> c2) {
        if (c1 == null && c2 == null) {
            return true;
        } else if (c1 == null || c2 == null) {
            return false;
        } else {
            if (c1.size() == c1.size()) {
                Set<T> c1Set = Sets.newHashSet(c1);
                Set<T> c2Set = Sets.newHashSet(c2);
                c2Set.removeAll(c1Set);
                return CollectionUtils.isEmpty(c2Set);
            } else {
                return false;
            }
        }
    }
}

package DNA.提升;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/30 17:38
 */
public class UnionFind {

    public static class Element<V> {
        public V value;
        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap; //将value包装
        public HashMap<Element<V>, Element<V>> fatherMap; //子元素对应父元素
        public HashMap<Element<V>, Integer> sizeMap; //某个集合的代表元素对应集合的大小

        public UnionFindSet(List<V> list) { //初始化
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        public boolean isSameSet(V a, V b) { //a b是否在同一集合
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }
        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aF = findHead(elementMap.get(a));
                Element<V> bF = findHead(elementMap.get(b));
                if (aF != bF) {
                    Element<V> big = sizeMap.get(aF) >= sizeMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    fatherMap.put(small, big); //较小的集合指向较大的集合
                    sizeMap.put(big, sizeMap.get(aF) + sizeMap.get(bF));
                    sizeMap.remove(small);
                }
            }
        }

        private Element<V> findHead(Element<V> element) { //一直向上找到代表元素
            Stack<Element<V>> path = new Stack<>();
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }
            while (!path.isEmpty()) { //将沿途的元素链指向代表元素
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

    }
}

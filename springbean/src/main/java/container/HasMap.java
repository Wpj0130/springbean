package container;

import java.util.function.Consumer;

/**
 * @Description 简易HashMap
 * @Author wangpeijin
 * @Date 2019/8/8 8:57
 * @Version 1.0
 **/
public class HasMap<K, V> {
    /**
     * HashMap 是链表+数组的数据结构
     */
    private Node<K, V>[] table;

    /**
     * 简单初始化容量。默认16
     */
    private Node<K, V>[] resize() {
        Node<K, V>[] oldTab = table;
        if (oldTab == null) {
            // 默认初始容量
            int DEFAULT_CAPACITY = 1 << 4;
            table = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];
        }
        return table;
    }

    /**
     * 模拟put方法
     */
    public V put(K key, V value) {
        int hash = hash(key); // 获取key的hash值
        // hash = 33;
        Node<K, V>[] tab; // 定义一个链表数组
        Node<K, V> p; // 定义一个节点对象
        int n, i; // 定义链表数组长度和下标
        // 如果链表数组为空则初始化一个默认容量的链表数组
        if ((tab = table) == null || (n = tab.length) == 0) {
            n = (tab = resize()).length;
        }
        // 通过(n-1)&hash方法快速定位数组下标。如果下标的节点为空
        // 则新增节点
        if ((p = tab[i = (n - 1) & hash]) == null) {
            tab[i] = new Node<>(hash, key, value, null);
        } else {
            Node<K, V> e;  // 如果下标节点存在，定义返回节点
            K k;  // 定义节点的key
            // 如果下标节点的hash值与放入的hash值相同并且key相等，则替换
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) {
                e = p;
            } else {
                // 如果hash值不同则需要遍历该下标的链表
                for (int binCount = 0; ; binCount++) {
                    // 如果下个节点为空，则放入下个节点
                    if ((e = p.next) == null) {
                        p.next = new Node<>(hash, key, value, null);
                        break;
                    }
                    // 如果下个节点的hash值与放入的hash值相同并且key相等
                    if ((e.hash == hash) && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        break;
                    }
                    // 交换目标节点
                    p = e;
                }
            }
            // 如果节点不为空   将新value设置到节点对象中并返回旧value
            if (e != null) {
                V oldValue = e.value;
                if (oldValue == null) {
                    e.value = value;
                }
                return oldValue;
            }
        }
        return null;
    }

    public V get(K key) {
        int hash = hash(key);// 获取key的hash值
        Node<K, V>[] tab;// 定义一个链表数组
        Node<K, V> first, e;// 定义首个节点和目标节点
        int n;//  定义链表数组长度
        K k; // 定义节点的key
        // 判断链表数组是否为空并判断第一个节点是否为空
        if ((tab = table) != null && (n = tab.length) > 0 && (first = tab[(n - 1) & hash]) != null) {
            // 如果第一个节点不为空，判断hash、key是否相等
            if (first.hash == hash && ((k = first.key) == key || (key != null && key.equals(k)))) {
                return first.value;
            }
            // 遍历判断是否有相同hash和key的下个节点
            if ((e = first.next) != null) {
                do {
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        return e.value;
                    }
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

    // 遍历
    public void forEach(Consumer<? super V> action) {
        for (Node<K, V> kvNode : table) {
            for (Node<K, V> e = kvNode; e != null; e = e.next)
                action.accept(e.value);
        }
    }

    private static int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}

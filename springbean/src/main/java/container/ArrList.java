package container;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * @Description 手写ArrayList
 * @Author wangpeijin
 * @Date 2019/11/4 18:10
 * @Version 1.0
 **/
public class ArrList<E> {

    // 集合大小
    private int size;

    // 集合内容
    private Object[] data;

    // 空数组实例
    private static final Object[] EMPTY_DATA = {};

    // 游标
    private int cur;

    // 默认大小
    private static final int DEFAULT_CAPACITY = 10;

    // 构造器
    ArrList() {
        initCapacity(DEFAULT_CAPACITY);
    }

    // 初始化容量
    @SuppressWarnings("unchecked")
    private void initCapacity(int newCapacity) {
        // 如果集合为空则初始化空数组
        data = data == null ? (E[]) EMPTY_DATA : data;
        E[] old = (E[]) data;
        data = new Object[newCapacity];
        if (size >= 0) System.arraycopy(old, 0, data, 0, size);
    }

    // 获取集合大小
    int size() {
        return size;
    }

    // 添加元素
    void add(E e) {
        if (size == data.length) {
            // 扩容1.5倍
            initCapacity(size + size >> 1);
        }
        data[size++] = e;
    }

    // 在固定下标插入元素
    void add(int index, E e) {
        check(index);

        if (size == data.length) {
            // 扩容1.5倍
            initCapacity(size + size >> 1);
        }

        System.arraycopy(data, index, data, index + 1, size - index);

        data[index] = e;
        size++;
    }

    // 校验下标
    private void check(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index err : " + index);
        }
    }

    // 判断集合是否为空
    boolean isEmpty() {
        return size == 0;
    }

    // 移除固定下标的元素
    E remove(int index) {
        E e = get(index);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return e;
    }

    // 获取固定下标元素
    @SuppressWarnings("unchecked")
    E get(int index) {
        check(index);
        return (E) data[index];
    }

    // 遍历集合
    void forEach(Consumer<Object> action) {
        Objects.requireNonNull(action);
        for (int i = 0; i < size; i++) {
            action.accept(data[i]);
        }
    }

    // 自带迭代器
    boolean hasNext() {
        return cur != size;
    }

    E next() {
        return get(cur++);
    }

}

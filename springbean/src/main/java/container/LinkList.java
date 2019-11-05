package container;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * @Description 手写LinkedList
 * @Author wangpeijin
 * @Date 2019/11/5 13:40
 * @Version 1.0
 **/
public class LinkList<E> {

    // 集合大小
    private int size;

    // 遍历的下个结点
    private int nextIndex;

    // 头结点
    private Node<E> head;

    // 尾结点
    private Node<E> end;

    // 默认构造方法
    public LinkList() {
    }

    // 添加元素(尾部)
    boolean add(E e) {
        Node<E> n = end;
        Node<E> newNode = new Node<>(n, e, null);
        end = newNode;
        if (n == null) {
            head = newNode;
        } else {
            n.next = newNode;
        }
        size++;
        return true;
    }

    // 获取固定下标节点
    private Node<E> getNode(int index) {
        // 二分查找法
        if (index < (size >> 1)) {
            Node<E> x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = end;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    // 获取固定下标的元素
    E get(int index) {
        check(index);
        return getNode(index).item;
    }

    // 移除固定下标的元素
    E remove(int index) {
        // 获取下标节点
        Node<E> node = getNode(index);
        E e = node.item;
        Node<E> next = node.next;
        Node<E> prev = node.prev;

        // 如果prev为空,说明该结点是头结点
        if (prev == null) {
            head = next;
        } else {
            // 否则将prev的尾指向该节点的next
            prev.next = next;
            node.prev = null;
        }

        // 如果next为空,说明该结点是尾结点
        if (next == null) {
            end = prev;
        } else {
            // 否则将next的头指向该节点的prev
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        return e;
    }

    // 遍历集合
    void forEach(Consumer<Object> action) {
        Objects.requireNonNull(action);
        for (int i = 0; i < size; i++) {
            action.accept(get(i));
        }
    }

    // 自带迭代器
    boolean hasNext() {
        return nextIndex < size;
    }

    E next() {
        return get(nextIndex++);
    }

    static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    // 校验下标
    private void check(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index err : " + index);
        }
    }
}

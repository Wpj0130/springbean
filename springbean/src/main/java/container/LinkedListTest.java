package container;

/**
 * @Description Java容器之LinkedList全解析
 * @Author wangpeijin
 * @Date 2019/11/5 10:55
 * @Version 1.0
 **/
public class LinkedListTest {
    public static void main(String[] args) {
        LinkList<Object> list = new LinkList<>();
        list.add(1);
        list.add(2);
        list.forEach(System.out::println);
        while (list.hasNext()) {
            System.out.println("迭代器:" + list.next());
        }
        System.out.println(list.get(1));
        System.out.println(list.remove(0));
        list.forEach(System.out::println);
    }
}

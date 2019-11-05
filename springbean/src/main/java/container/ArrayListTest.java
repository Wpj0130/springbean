package container;

/**
 * @Description Java容器之ArrayList全解析
 * @Author wangpeijin
 * @Date 2019/11/4 14:02
 * @Version 1.0
 **/

public class ArrayListTest {


    public static void main(String[] args) {
        ArrList<String> list = new ArrList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        while (list.hasNext()) {
            System.out.println("第一次:" + list.next());
        }
        System.out.println(list.get(-1));
        System.out.println(list.isEmpty());
    }


}

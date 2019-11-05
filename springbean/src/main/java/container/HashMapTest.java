package container;

import java.util.HashMap;

/**
 * @Description Java容器之HashMap
 * @Author wangpeijin
 * @Date 2019/11/5 14:41
 * @Version 1.0
 **/
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        HasMap<Object, Object> map1 = new HasMap<>();
        for (int i = 0; i < 10; i++) {
            map1.put("k" + i, "v" + i);
            System.out.println(map1.get("k" + i));
        }
        // map1.forEach(System.out::println);
    }
}

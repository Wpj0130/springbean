package test;

/**
 * @Description
 * @Author wangpeijin
 * @Date 2019/10/31 16:44
 * @Version 1.0
 **/

import org.junit.Assert;
import org.junit.Test;

/**
 * Function:是否是环链表，采用快慢指针，一个走的快些一个走的慢些 如果最终相遇了就说明是环
 * 就相当于在一个环形跑道里跑步，速度不一样的最终一定会相遇。
 * @author crossoverJie
 * Date: 04/01/2018 11:33
 * @since JDK 1.8
 */
public class LinkLoop {

    public static class Node {
        private Object data;
        public Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data) {
            this.data = data;
        }
    }

    /**
     * 判断链表是否有环
     * @param node
     * @return
     */
    public boolean isLoop(Node node) {
        Node slow = node;
        Node fast = node.next;

        while (slow.next != null) {
            Object dataSlow = slow.data;
            Object dataFast = fast.data;

            //说明有环
            if (dataFast == dataSlow) {
                return true;
            }

            //一共只有两个节点，但却不是环形链表的情况，判断NPE
            if (fast.next == null) {
                return false;
            }
            //slow走慢点  fast走快点
            slow = slow.next;
            fast = fast.next.next;

            //如果走的快的发现为空 说明不存在环
            if (fast == null) {
                return false;
            }
        }
        return false;
    }

    public class LinkLoopTest {

        /**
         * 无环
         * @throws Exception
         */
        @Test
        public void isLoop() throws Exception {
            LinkLoop.Node node3 = new LinkLoop.Node("3");
            LinkLoop.Node node2 = new LinkLoop.Node("2");
            LinkLoop.Node node1 = new LinkLoop.Node("1");

            node1.next = node2;
            node2.next = node3;

            LinkLoop linkLoop = new LinkLoop();
            boolean loop = linkLoop.isLoop(node1);
            Assert.assertEquals(loop, false);
        }

        /**
         * 有环
         * @throws Exception
         */
        @Test
        public void isLoop2() throws Exception {
            LinkLoop.Node node3 = new LinkLoop.Node("3");
            LinkLoop.Node node2 = new LinkLoop.Node("2");
            LinkLoop.Node node1 = new LinkLoop.Node("1");

            node1.next = node2;
            node2.next = node3;
            node3.next = node1;

            LinkLoop linkLoop = new LinkLoop();
            boolean loop = linkLoop.isLoop(node1);
            Assert.assertEquals(loop, true);
        }

        /**
         * 无环
         * @throws Exception
         */
        @Test
        public void isLoop3() throws Exception {
            LinkLoop.Node node2 = new LinkLoop.Node("2");
            LinkLoop.Node node1 = new LinkLoop.Node("1");

            node1.next = node2;


            LinkLoop linkLoop = new LinkLoop();
            boolean loop = linkLoop.isLoop(node1);
            Assert.assertEquals(loop, false);
        }

    }
}

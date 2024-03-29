package test;

/**
 * @Description
 * @Author wangpeijin
 * @Date 2019/10/31 16:43
 * @Version 1.0
 **/

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Function: 判断一个数字是否为快乐数字 19 就是快乐数字  11就不是快乐数字
 * 19
 * 1*1+9*9=82
 * 8*8+2*2=68
 * 6*6+8*8=100
 * 1*1+0*0+0*0=1
 * <p>
 * 11
 * 1*1+1*1=2
 * 2*2=4
 * 4*4=16
 * 1*1+6*6=37
 * 3*3+7*7=58
 * 5*5+8*8=89
 * 8*8+9*9=145
 * 1*1+4*4+5*5=42
 * 4*4+2*2=20
 * 2*2+0*0=2
 * <p>
 * 这里结果 1*1+1*1=2 和 2*2+0*0=2 重复，所以不是快乐数字
 * @author crossoverJie
 * Date: 04/01/2018 14:12
 * @since JDK 1.8
 */
public class HappyNum {

    /**
     * 判断一个数字是否为快乐数字
     * @param number
     * @return
     */
    public boolean isHappy(int number) {
        Set<Integer> set = new HashSet<>(30);
        while (number != 1) {
            int sum = 0;
            while (number > 0) {
                //计算当前值的每位数的平方 相加的和 在放入set中，如果存在相同的就认为不是 happy数字
                sum += (number % 10) * (number % 10);
                number = number / 10;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
            number = sum;
        }
        return true;
    }

    public class HappyNumTest {
        @Test
        public void isHappy() throws Exception {
            HappyNum happyNum = new HappyNum();
            boolean happy = happyNum.isHappy(19);
            Assert.assertEquals(happy, true);
        }

        @Test
        public void isHappy2() throws Exception {
            HappyNum happyNum = new HappyNum();
            boolean happy = happyNum.isHappy(11);
            Assert.assertEquals(happy, false);
        }

        @Test
        public void isHappy3() throws Exception {
            HappyNum happyNum = new HappyNum();
            boolean happy = happyNum.isHappy(100);
            System.out.println(happy);
        }

    }

}

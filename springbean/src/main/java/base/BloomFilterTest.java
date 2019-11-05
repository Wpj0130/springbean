package base;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @Author: wangheling
 * @Date: 2019/11/4 10:08
 * @Description: 布隆过滤器
 */
public class BloomFilterTest {

    public static void main(String[] args) {
        int num = 1000000;
        //设置一个布隆过滤器 谷歌guava有现成工具
        //  <dependency>
        //      <groupId>com.google.guava</groupId>
        //      <artifactId>guava</artifactId>
        //      <version>25.0-jre</version>
        //  </dependency>
        //设置元素类型为string，错误率默认3%，可以自行设置，错误率越低，底层的bitmap数组越大，hash计算次数越多，性能越差，但错误率不可能为0
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), num);
//        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), num, 0.01);

        //存放存在的uuid
        List<String> list = new ArrayList<>(num + 1);
        //用来验证布隆过滤器判断是否正确
        Set<String> set = new HashSet<>();
        for (int i = 0; i < num; i++) {
            String uuid = UUID.randomUUID().toString();
            //往过滤器添加值
            bloomFilter.put(uuid);
            list.add(uuid);
            set.add(uuid);
        }

        int right = 0;
        int err = 0;
        int count = 0;
        for (int i = 0; i < num; i++) {
            if (i % 100 == 0) {
                count++;
                //判断已有的元素是否存在
                if (bloomFilter.mightContain(list.get(i))) {
                    right++;
                    continue;
                }
                err++;
            }
        }
        System.out.println("判读实际存在的正确个数：" + right + ",错误个数：" + err + ",错误率：" + accuracy(Double.valueOf(err + ""), Double.valueOf(count + ""), 2));

        int right2 = 0;
        int err2 = 0;
        int count2 = 0;
        for (int i = 0; i < num; i++) {
            if (i % 100 == 0) {
                count2++;
                String newUuid = UUID.randomUUID().toString();
                //生产新元素判断是否存在
                if (!bloomFilter.mightContain(newUuid) && !set.contains(newUuid)) {
                    right2++;
                    continue;
                }
                err2++;
            }
        }
        System.out.println("判读实际不存在的正确个数：" + right2 + ",错误个数：" + err2 + ",错误率：" + accuracy(Double.valueOf(err2 + ""), Double.valueOf(count2 + ""), 2));


    }

    public static String accuracy(double num, double total, int scale) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        //可以设置精确几位小数
        df.setMaximumFractionDigits(scale);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);
        double accuracy_num = num / total * 100;
        return df.format(accuracy_num) + "%";
    }

}

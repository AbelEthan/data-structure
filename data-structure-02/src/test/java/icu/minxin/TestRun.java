package icu.minxin;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: TestRun
 * @Author AbelEthan
 * @Email AbelEthan@126.com
 * @Date 2021/5/27 下午2:30
 * @Description
 */
public class TestRun {
    private Set<String> words;

    @Before
    public void before() {
        words = FileUtil.readWordList("code.txt");
    }

    @Test
    public void testHashCode() {
        String str = "敏芯";
        int hashCode1 = str.hashCode();
        System.out.println("--------hashcode1--------");
        System.out.println("十进制:" + hashCode1);
        System.out.println("二进制:" + Integer.toBinaryString(hashCode1));

        int hashcode2 = hashCode1 >>> 16;
        System.out.println("--------hashcode2--------");
        System.out.println("十进制:" + hashcode2);
        System.out.println("二进制:" + Integer.toBinaryString(hashcode2));

        int hashcode3 = hashCode1 ^ hashcode2;
        System.out.println("--------hashcode3--------");
        System.out.println("十进制:" + hashcode3);
        System.out.println("二进制:" + Integer.toBinaryString(hashcode3));

        int hashcode4 = hashcode3 & 7;
        System.out.println("--------hashcode4--------");
        System.out.println("下标[7]二进制:" + Integer.toBinaryString(7));
        System.out.println("十进制:" + hashcode4);
        System.out.println("二进制:" + Integer.toBinaryString(hashcode4));
    }

    @Test
    public void testHashIdx() {
        Set<String> strings = FileUtil.readWordList("code.txt");
        Map<Integer, Integer> map = new HashMap<>(16);
        for (String word : strings) {
            int idx = Disturb.hashIdx(word, 128);
            if (map.containsKey(idx)) {
                Integer integer = map.get(idx);
                map.put(idx, ++integer);
            } else {
                map.put(idx, 1);
            }
        }
        System.out.println(map.values());
    }

    @Test
    public void testDisturbHashIdx() {
        Set<String> strings = FileUtil.readWordList("code.txt");
        Map<Integer, Integer> map = new HashMap<>(16);
        for (String word : strings) {
            int idx = Disturb.disturbHashIdx(word, 128);
            if (map.containsKey(idx)) {
                Integer integer = map.get(idx);
                map.put(idx, ++integer);
            } else {
                map.put(idx, 1);
            }
        }
        System.out.println(map.values());
    }
}

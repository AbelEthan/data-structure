package icu.minxin.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Test
 * @Author AbelEthan
 * @Email AbelEthan@126.com
 * @Date 2021/5/25 下午5:15
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Set<String> strings = FileUtil.readWordList("code.txt");
        Map<Integer, Integer> map = new HashMap<>(16);
        for (String word : strings) {
            int idx = Disturb.hashIdx(word, 128);
            if (map.containsKey(idx)){
                Integer integer = map.get(idx);
                map.put(idx, ++integer);
            }else {
                map.put(idx, 1);
            }
        }
        System.out.println(map.values());
    }


    public static void disturbTest(){
        String str = "敏芯";
        int hashCode1 = str.hashCode();
        System.out.println("hashcode1");
        System.out.println(hashCode1);
        System.out.println(Integer.toBinaryString(hashCode1));

        int hashcode2 = hashCode1 >>> 16;
        System.out.println("hashcode2");
        System.out.println(hashcode2);
        System.out.println(Integer.toBinaryString(hashcode2));

        int hashcode3 = hashCode1 ^ hashcode2;
        System.out.println("hashcode3");
        System.out.println(hashcode3);
        System.out.println(Integer.toBinaryString(hashcode3));

        int hashcode4 = hashcode3 & 7;
        System.out.println("hashcode4");
        System.out.println(Integer.toBinaryString(7));
        System.out.println(hashcode4);
        System.out.println(Integer.toBinaryString(hashcode4));
    }
}

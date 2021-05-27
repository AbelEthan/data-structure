package icu.minxin;

import java.util.List;
import java.util.Set;

/**
 * @ClassName: Test
 * @Author AbelEthan
 * @Email AbelEthan@126.com
 * @Date 2021/5/13 下午4:40
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        testHashRate();
        testHashArea();
    }

    public static void testHashRate(){
        Set<String> strings = FileUtil.readWordList("code.txt");
        List<RateInfo> rateInfos = HashCode.collisionRateList(strings, 2, 3, 5, 7, 17, 31, 32, 33, 39, 41, 199);
        for (RateInfo rateInfo : rateInfos) {
            System.out.println(rateInfo.toString());
        }
    }

    public static void  testHashArea() {
        Set<String> strings = FileUtil.readWordList("code.txt");
        System.out.println(HashCode.hashArea(strings, 2).values());
        System.out.println(HashCode.hashArea(strings, 7).values());
        System.out.println(HashCode.hashArea(strings, 31).values());
        System.out.println(HashCode.hashArea(strings, 32).values());
        System.out.println(HashCode.hashArea(strings, 199).values());
    }


}

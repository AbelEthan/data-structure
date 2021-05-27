package icu.minxin;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * @ClassName: Application
 * @Author AbelEthan
 * @Email AbelEthan@126.com
 * @Date 2021/5/27 下午2:23
 * @Description
 */
public class TestRun {

    private Set<String> words;

    @Before
    public void before(){
        words = FileUtil.readWordList("code.txt");
    }

    @Test
    public void testHashRate(){
        List<RateInfo> rateInfos = HashCode.collisionRateList(words, 2, 3, 5, 7, 17, 31, 32, 33, 39, 41, 199);
        for (RateInfo rateInfo : rateInfos) {
            System.out.println(rateInfo.toString());
        }
    }

    @Test
    public void  testHashArea() {
        System.out.println(HashCode.hashArea(words, 2).values());
        System.out.println(HashCode.hashArea(words, 7).values());
        System.out.println(HashCode.hashArea(words, 31).values());
        System.out.println(HashCode.hashArea(words, 32).values());
        System.out.println(HashCode.hashArea(words, 199).values());
    }
}

package icu.minxin;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TestRun
 * @Author AbelEthan
 * @Email AbelEthan@126.com
 * @Date 2021/5/27 下午3:22
 * @Description
 */
public class TestRun {

    @Test
    public void testIterator() {
        Map<String, String> map = new HashMap<String, String>(64);
        map.put("24", "Idx：2");
        map.put("46", "Idx：2");
        map.put("68", "Idx：2");
        map.put("29", "Idx：7");
        map.put("150", "Idx：12");
        map.put("172", "Idx：12");
        map.put("194", "Idx：12");
        map.put("271", "Idx：12");
        System.out.println("排序 01：");
        for (String key : map.keySet()) {
            System.out.print(key + ":" + (key.hashCode() & 63) + " ");
        }
        map.put("293", "Idx：12");
        map.put("370", "Idx：12");
        map.put("392", "Idx：12");
        map.put("491", "Idx：12");
        map.put("590", "Idx：12");
        System.out.println("\n\n 排序 02：");
        for (String key : map.keySet()) {
            System.out.print(key + ":" + (key.hashCode() & 63) + " ");
        }
        map.remove("293");
        map.remove("370");
        map.remove("392");
        map.remove("491");
        map.remove("590");
        System.out.println("\n\n 排序 03：");
        for (String key : map.keySet()) {
            System.out.print(key + ":" + (key.hashCode() & 63) + " ");
        }
    }
}

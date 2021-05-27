package icu.minxin.hashcode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: FileUtil
 * @Author AbelEthan
 * @Email AbelEthan@126.com
 * @Date 2021/5/13 下午4:57
 * @Description
 */
public class FileUtil {

    public static Set<String> readWordList(String uri) {
        Set<String> sets = new HashSet<>();
        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(uri);
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] ss = line.split("\t");
                sets.add(ss[1]);
            }
            br.close();
            isr.close();
            is.close();
        } catch (IOException e) {
            return null;
        }
        return sets;
    }
}

package icu.minxin;

/**
 * @ClassName: Disturb
 * @Author AbelEthan
 * @Email AbelEthan@126.com
 * @Date 2021/5/25 下午5:25
 * @Description
 */
public class Disturb {

    /**
     * 扰动函数下，下标计算
     *
     * @param key
     * @param size
     * @return
     */
    public static int disturbHashIdx(String key, int size) {
        int hashCode = key.hashCode();
        return (hashCode ^ (hashCode >>> 16)) & (size - 1);
    }

    /**
     * 非扰动函数下，下标值计算
     *
     * @param key
     * @param size
     * @return
     */
    public static int hashIdx(String key, int size) {
        return key.hashCode() & (size - 1);
    }
}

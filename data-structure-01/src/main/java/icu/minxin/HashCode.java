package icu.minxin;

import java.util.*;

/**
 * @ClassName: HashCode
 * @Author AbelEthan
 * @Email AbelEthan@126.com
 * @Date 2021/5/13 下午4:34
 * @Description
 */
public class HashCode {
    public static Integer hashCode(String str, Integer multiplier) {
        int hash = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            hash = multiplier * hash + str.charAt(i);
        }
        return hash;
    }

    private static RateInfo hashCollisionRate(Integer multiplier, List<Integer> hashCodeList) {
        Integer maxHash = hashCodeList.stream().max(Integer::compareTo).get();
        Integer minHash = hashCodeList.stream().min(Integer::compareTo).get();

        int collisionCount = hashCodeList.size() - (int) hashCodeList.stream().distinct().count();
        double collisionRate = (collisionCount * 1.0) / hashCodeList.size();
        return new RateInfo(maxHash, minHash, multiplier, collisionCount, collisionRate);
    }

    public static List<RateInfo> collisionRateList(Set<String> strList, Integer... multipliers) {
        List<RateInfo> rateInfoList = new ArrayList<>(multipliers.length);
        for (Integer multiplier : multipliers) {
            List<Integer> hashCodeList = new ArrayList<>(strList.size());
            for (String str : strList) {
                Integer hashCode = hashCode(str, multiplier);
                hashCodeList.add(hashCode);
            }
            rateInfoList.add(hashCollisionRate(multiplier, hashCodeList));
        }
        return rateInfoList;
    }

    public static Map<Integer, Integer> hashArea(List<Integer> hashCodeList) {
        Map<Integer, Integer> statistics = new LinkedHashMap<>();
        int start = 0;
        for (long i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i+= 67108864) {
            long min = i;
            long max = min + 67108864;
            int num = (int) hashCodeList.parallelStream().filter(x -> x >= min && x < max).count();
            statistics.put(start++, num);
        }
        return statistics;
    }

    public static Map<Integer, Integer> hashArea(Set<String> strList, Integer multiplier){
        List<Integer> hashCodeList = new ArrayList<>(strList.size());
        for (String str : strList) {
            Integer hashCode = hashCode(str, multiplier);
            hashCodeList.add(hashCode);
        }
        return hashArea(hashCodeList);
    }

}

package icu.minxin.hashcode;

import lombok.Data;

/**
 * @ClassName: RateInfo
 * @Author AbelEthan
 * @Email AbelEthan@126.com
 * @Date 2021/5/13 下午4:42
 * @Description
 */
@Data
public class RateInfo {
    /**
     * 最大Hash
     */
    private int maxHash;
    /**
     * 最小Hash
     */
    private int minHash;

    /**
     * hash计算乘机因子
     */
    private int multiplier;
    /**
     * 碰撞数
     */
    private int collisionCount;
    /**
     * 碰撞比率
     */
    private double collisionRate;

    public RateInfo(int maxHash, int minHash, int multiplier, int collisionCount, double collisionRate) {
        this.maxHash = maxHash;
        this.minHash = minHash;
        this.multiplier = multiplier;
        this.collisionCount = collisionCount;
        this.collisionRate = collisionRate;
    }

    @Override
    public String toString() {
        return String.format(
                "乘数 = %4d, 最小Hash = %11d, 最大Hash = %10d, 碰撞数量 =%6d, 碰撞概率 = %.4f%%",
                this.getMultiplier(),
                this.getMinHash(),
                this.getMaxHash(),
                this.getCollisionCount(),
                this.getCollisionRate() * 100
        );
    }
}

package chap8;

import java.util.Random;

public class RandomT {

    private static final Random rnd = new Random();

    /**
     *  三个缺点： 1：如果n是一个比较小的2的乘方，经过一段相当短的周期之后，它产生的随机数序列将会重复
     *  2：如果n不是2的乘方，那么平均起来，有些数会比其他的数出现的更为频繁，如果n比较大，这个缺点就会非常明显
     * 3:在极少数情况下，它的失败是灾难性的，返回一个落在指定范围外的数
     *
     */
    static int random(int n){
        return Math.abs(rnd.nextInt() % n);
    }


/*

    //2.eg
    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (random(n)< n/2)
                low++;

            System.out.println(low);
        }
    }
*/




}

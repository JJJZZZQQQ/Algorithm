package 剑指offer;

public class 数组中数字出现的次数Ⅰ {

    /** 分两组找出两个数
     * 如何分组？
     * 所有值异或的最终结果，找到一位二进制为1的数位，用这个位置跟其他的数进行与运算，结果为1的在一组，结果为0的在一组
     * 理由：
     * 为1的数位，说明要求的这两个数的该位置的值不同，不然肯定为0，因为相同的数异或后为0
     * 那么这两个不同的数一定会在不同的分组，然后再来看相同的数为什么这么分组能刚好分在同一个组
     * 由于相同的数这个位置上的值肯定相同，自然会被分到一个分组。*/
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for(int x : nums){
            res ^= x;
        }
        //找到res中的一个为1的位
        int dev = 1;
        while((res & dev) == 0) {
            dev <<= 1;
        }
        int a = 0,b = 0;
        for(int x : nums){
            if((x & dev) ==0) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        return new int[] {a,b};
    }
}

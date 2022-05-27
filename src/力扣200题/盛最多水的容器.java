package 力扣200题;

public class 盛最多水的容器 {

    /**
     * 扩大容器太多情况要考虑了，很难实现
     * 但如果是缩小窗口的话，由于不管是缩小左边还是缩小右边，横坐标对结果都是一样的
     * 那么我们就可以在缩小窗口的时候只考虑高度 ，根据贪心的思路，每次缩的时候选择一个短板缩
     * 然后动态的维护最大面积即可
     */
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            //如果左边的短，就移左边，右边的短就移右边 贪心的思想，因为板子肯定越长越好
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++])://移动左边，判断新的面积与旧的哪个大
                    Math.max(res, (j - i) * height[j--]);//移动右边，判断新的面积与旧的哪个大
        }
        return res;
    }


}

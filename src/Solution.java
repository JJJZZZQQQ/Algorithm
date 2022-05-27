import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean solution(int[][] trips, int capacity) {
        //    {2, 1, 5}, {3, 3, 7}}, 4
        Map<Integer,Integer> map = new HashMap<>();

        int length = trips.length;

        for (int i = 0; i < length; i++) {
            map.put(trips[i][1] , -trips[i][0]);
            map.put(trips[i][2] , trips[i][0]);
        }

        for(int i = 0 ; i < 1000 ;i++) {
            if(!map.containsKey(i)) {
                continue;
            }
            int num = map.get(i);
            capacity += num;
            if(capacity < 0)return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
        System.out.println(solution.solution(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
    }
}
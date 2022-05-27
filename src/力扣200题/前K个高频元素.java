package 力扣200题;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        int [] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        PriorityQueue<int []> queue = new PriorityQueue<>( (a,b) -> b[1] -a[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int key = entry.getKey() , count = entry.getValue();
            if(queue.size() == k) {
                if(queue.peek()[1] < count){
                    queue.poll();
                }
            }
            queue.add(new int[]{key,count});
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }

        return res;
    }
}

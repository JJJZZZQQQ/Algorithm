package 力扣200题;

public class 任务调度器 {
    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        int size = tasks.length;
        int res = 0;
        while (size > 0) {
            int t = n + 1;
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    res++;
                    count[i]--;
                    size--;
                    t--;
                }
            }
            while (t > 0 && size > 0) {
                res++;
                t--;
            }
        }
        return res;
    }

    /** 不需要排序，因为肯定是先用出现最多的那一个，只要找到出现次数最多的那一个字母就行*/
    public int leastInterval2(char[] tasks, int n) {
        int[] temp = new int[26];
        //数量最多的任务有几个，因为可能有出现次数相同的任务
        int countMaxTask = 0;
        //最多任务的数量
        int maxTask = 0;
        for (char c : tasks) {
            temp[c - 'A']++;
            maxTask = Math.max(temp[c - 'A'], maxTask);
        }
        for (int i = 0; i < 26; i++) {
            if (temp[i] == maxTask) {
                countMaxTask++;
            }
        }
        return Math.max(tasks.length, (maxTask - 1) * (n + 1) + countMaxTask);
    }
}

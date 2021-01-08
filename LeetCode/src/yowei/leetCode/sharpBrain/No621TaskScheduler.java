package yowei.leetCode.sharpBrain;

/**
 * 任务调度
 * 有多个任务，相同的任务冷却时间为n，求最短时间
 * 建立m(数量最多的任务数量)个桶,每个桶长度为n+1，基本大小为(m-1)*(n+1)
 * 然后附加额外的任务数量：当任务数没有装满所有桶时，只需加上最后一个桶的大小，即也拥有m个数量的任务的数量
 * 当所有桶都装满后，这时剩余的任务只需接到各个桶的最后面，随便插入都能满足条件
 */
public class No621TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] temp = new int[26];
        int countMaxTask = 0;
        int maxTask=0;

        //找到数量最多的任务数量
        for(char c:tasks){
            temp[c-'A']++;
            maxTask = Math.max(temp[c-'A'],maxTask);
        }
        for(int i=0;i<26;i++){
            if(temp[i]==maxTask){
                countMaxTask++;
            }
        }
        return Math.max(tasks.length,(maxTask-1)*(n+1)+countMaxTask);
    }
}

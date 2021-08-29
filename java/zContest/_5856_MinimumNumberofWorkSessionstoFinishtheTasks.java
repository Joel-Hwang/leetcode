package zContest;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _5856_MinimumNumberofWorkSessionstoFinishtheTasks {
    int res;
    int maxSessionTime;
    int[] tasks;
    int[] sessions;
    //prune, backtracking
    public int minSessions(int[] tasks, int sessionTime) {
        reverseSort(tasks);
        this.res = tasks.length;
        this.maxSessionTime = sessionTime;
        this.tasks = tasks;
        this.sessions = new int[tasks.length];
        dfs(0, 0);
        return res;
    }

    private void dfs(int taskID, int sessionCount) {
        if (sessionCount > res)
            return; // prune, withoud this it will take 2200ms
        if (taskID == tasks.length) {
            res = Math.min(res, sessionCount);
            return;
        }
        for (int i = 0; i < sessionCount; i++) {
            if (sessions[i] + tasks[taskID] <= maxSessionTime) {
                sessions[i] += tasks[taskID];
                dfs(taskID + 1, sessionCount);
                sessions[i] -= tasks[taskID];
            }
        }
        sessions[sessionCount] += tasks[taskID];
        dfs(taskID + 1, sessionCount + 1);
        sessions[sessionCount] -= tasks[taskID];
    }

    private void reverseSort(int[] tasks) {
        Arrays.sort(tasks);
        for (int i = 0; i < tasks.length / 2; i++) {
            int temp = tasks[i];
            tasks[i] = tasks[tasks.length-1-i];
            tasks[tasks.length-1-i] = temp;
        }
    }

    @Test
    public void test(){
        System.out.println(minSessions(new int[]{3,1,3,1,1}, 8));
    }
}

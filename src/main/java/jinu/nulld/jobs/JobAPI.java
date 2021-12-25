package jinu.nulld.jobs;

import org.bukkit.entity.Player;

import static jinu.nulld.jobs.Jobs.*;

public class JobAPI {
    /**
     * 플레이어의 직업을 설정합니다.
     * 이전 직업이 있다면 그 직업을 없애고 새로 부여합니다.
     * @param p 플레이어
     * @param j 직업
     */
    public static void setJob(Player p, Jobs j) {
        if (jobMap.get(p) != null) jobMap.remove(p);
        jobMap.put(p, j);
    }

    /**
     * 플레이어의 직업을 가져옵니다.
     * @param p 플레이어
     */
    public static Jobs getJob(Player p) {
        if (jobMap.get(p) != null) return jobMap.get(p);
        else return Jobs.NONE;
    }
    public static Jobs getJobByName(String jobName) {
        if (jobName != null && JOBNAME_TO_JOBS.containsKey(jobName)) return JOBNAME_TO_JOBS.get(jobName);
        else return NONE;
    }
}

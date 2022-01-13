package jinu.nulld.jobs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

import static jinu.nulld.jobs.Jobs.*;

public class JobAPI {

    /**
     * 플레이어의 직업을 설정합니다.
     * 이전 직업이 있다면 그 직업을 없애고 새로 부여합니다.
     * @param p 플레이어
     * @param j 직업
     */
    public static void setJob(Player p, Jobs j) {
        jobMap.put(p.getUniqueId(), j);
    }

    public static void setJob(UUID uuid, Jobs j){
        jobMap.put(uuid, j);
    }


    /**
     * 플레이어의 직업을 가져옵니다.
     * @param p 플레이어
     */
    public static Jobs getJob(Player p) {
        return jobMap.getOrDefault(p.getUniqueId(), NONE);
    }

    public static Jobs getJob(UUID uuid){
        return jobMap.getOrDefault(uuid, NONE);
    }


    /**
     * 해당 직업을 가진 플레이어를 불러옵니다.
     * @param job 직업
     * @return 플레이어
     */
    public static Player getPlayerByJob(Jobs job){
        for(Player ap : Bukkit.getOnlinePlayers()){
            if(jobMap.containsKey(ap.getUniqueId()) && jobMap.get(ap.getUniqueId()) == job)
                return ap;
        }
        return null;
    }

    public static UUID getUUIDByJob(Jobs job){
        for(UUID uuid : jobMap.keySet()){
            if(jobMap.get(uuid) == job) return uuid;
        }
        return null;
    }

    public static Jobs getJobByName(String jobName) {
        if (jobName != null && JOBNAME_TO_JOBS.containsKey(jobName)) return JOBNAME_TO_JOBS.get(jobName);
        else return NONE;
    }
}

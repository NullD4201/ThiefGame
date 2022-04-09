package jinu.nulld.jobs;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public enum Jobs {
    MECHANIC("기계 업체 대표", "매 밤마다 1명의 방 입구를 강제로 틀어막을 수 있습니다." +
            "\n입구가 막힌 방은 들어가거나 나올 수 없습니다.", 1),
    CLERK("행정 업체 대표", "모든 투표에서 본인의 표는 2표로 취급됩니다.", 2),
    ACCOUNTING("회계 업체 대표", "토론 시간 때 1명을 지목해 대상이 해당 라운드에 금괴를 움직였는지 알 수 있습니다.", 3),
    SECURITY("보안 업체 대표", "토론 시간 때 1명을 고르면 2개의 직업이 제시됩니다. 둘 중 하나가 대상의 직업입니다.", 4),
    INTERNET("인터넷 업체 대표", "매 밤마다 1명의 방에 1회 무조건 난입할 수 있습니다.", 5),
    CITIZEN("시민 대표", "게임 중 특정인 능력 봉인, 피고인 투표 회피 능력을 각각 한 번씩 사용할 수 있습니다.", 6),
    ARCHITECT("건축 업체 대표", "매 라운드 금고 2군데 중 진짜 금괴가 위치할 금고 1군데를 선택할 수 있습니다.", 7),
    GUARD("경비 업체 대표", "수색 시간마다 항상 첫 번째 조에 배치되며, \n해당 라운드 동안 특정인의 상자 2개를 모두 잠글 수 있는 카드키를 지급받습니다.", 8),
    // NONE의 경우 접속 시 부여받습니다.
    NONE("직업 없음", "정해진 직업이 없습니다.", 0);

    public final static Map<UUID, Jobs> jobMap = new HashMap<>();
    public final static Map<String, Jobs> JOBNAME_TO_JOBS = new HashMap<>();

    private boolean abilityUsed;

    private final String jobName;
    private final String jobDescription;
    private final int helmetCustomData;

    Jobs(String jobName, String jobDescription, int helmetCustomData) {
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.helmetCustomData = helmetCustomData;
        this.abilityUsed = false;
    }

    public boolean isAbilityUsed(){
        return this.abilityUsed;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }


    public void setAbilityUsed(boolean used){
        this.abilityUsed = used;
    }

    public void helmet(Player p){

        if(helmetCustomData == 0){
            p.getInventory().setHelmet(new ItemStack(Material.AIR));
            return;
        }

        ItemStack is = new ItemStack(Material.FEATHER);
        ItemMeta ism = is.getItemMeta();
        ism.setDisplayName("§e" + jobName + " §f명찰");
        ism.setCustomModelData(helmetCustomData);
        is.setItemMeta(ism);
        p.getInventory().setHelmet(is);
    }

    // 플러그인 리로드 시 모두의 직업을 NONE으로 설정합니다.
    public static void setNone(){
        for (Player player : Bukkit.getOnlinePlayers()){
            JobAPI.setJob(player, Jobs.NONE);
        }
    }

    // API 실행 시 Map에 이름과 직업을 매칭합니다.
    public static void register(){
        for (Jobs j : Jobs.values()) JOBNAME_TO_JOBS.put(j.jobName, j);
    }
}

package jinu.nulld.jobs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public enum Jobs {
    MECHANIC("기계 업체 대표", "매 라운드 1회에 한해 밤에 특정인 방의 초인종을 고장냅니다."),
    CLERK("행정 업체 대표", "모든 투표에서 본인의 표는 2표로 취급된다."),
    ACCOUNTING("회계 업체 대표", "매 라운드 1회에 한해 50% 확률로 대상자가 괴도인지 아닌지 본인만 알 수 있다."),
    SECURITY("보안 업체 대표", "대상자의 직업을 확인할 수 있다. 단, 진짜와 가짜 직업 2가지가 함께 제시된다."),
    INTERNET("인터넷 업체 대표", "매 라운드 1회에 한해 밤 시간에 방 최대 인원제한 상관없이 난입이 가능하다."),
    CITIZEN("시민 대표", "게임 중 <대상자 침묵 1회권>과 <피고인투표 회피 1회권>을 하나씩 지급받는다."),
    ARCHITECT("건축 업체 대표", "매 라운드 금고 2군데 중 진짜 금괴가 위치할 금고 1군데를 선택할 수 있다."),
    GUARD("경비 업체 대표", "항상 첫 번째 조에 배치되며, 열쇠 아이템을 이용해 1개의 금고를 잠가 그 상자를 열 수 없게 할 수 있다."),
    // NONE의 경우 접속 시 부여받습니다.
    NONE("직업 없음", "정해진 직업이 없습니다.");

    public final static Map<UUID, Jobs> jobMap = new HashMap<>();
    public final static Map<String, Jobs> JOBNAME_TO_JOBS = new HashMap<>();

    private final String jobName;
    private final String jobDescription;

    Jobs(String jobName, String jobDescription) {
        this.jobName = jobName;
        this.jobDescription = jobDescription;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    // 플러그인 리로드 시 모두의 직업을 NONE으로 설정합니다.
    public static void setNone(){
        for (Player player : Bukkit.getOnlinePlayers()) jobMap.put(player.getUniqueId(), NONE);
    }

    // API 실행 시 Map에 이름과 직업을 매칭합니다.
    public static void register(){
        for (Jobs j : Jobs.values()) JOBNAME_TO_JOBS.put(j.jobName, j);
    }
}

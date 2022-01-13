package jinu.nulld.jobs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public enum Jobs {
    DETECTIVE("형사", "누가 어느 은행에 입장했는지와 공원 대화 내용을 실시간으로 확인 가능하다."),
    JUDGE("판사", "모든 투표에서 자신의 표는 3표로 취급된다."),
    COUNSEL("검사", "1회에 한해 법정에 2명을 세워 두 사람 중 괴도가 있는지 공지하는 권한을 가진다."),
    HACKER("해커", "토론 시간 때마다 2명을 해킹하여 괴도 여부를 확인할 수 있다. 단, 성공 확률은 각각 30%."),
    GANG("깡패", "토론 시간 때마다 1명의 마이크를 막을 수 있다."),
    AGENT("보안요원", "게임 중 단 2회 타인의 몸 수색이 가능하다."),
    BANKPRESIDENT("은행장", "매 라운드마다 A은행과 B은행 중 가짜 금괴와 진짜 금괴가 위치할 곳을 선택할 수 있다."),
    BANKCLERK("은행원", "수색 시간 때마다 타인 1명의 금고를 열어볼 수 있다. 항상 마지막 수색조에 배정된다."),
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

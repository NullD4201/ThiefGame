package jinu.nulld.jobs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public enum Jobs {
    DETECTIVE("형사", "누가 어느 은행에 입장했는지와 공원 대화 내용을 실시간으로 확인 가능하다."),
    JUDGE("판사", "원할 때 1명을 두고 괴도 재판을 여는 권한을 가지며 횟수는 3번이다."),
    COUNSEL("검사", "1회에 한해 법정에 2명을 세워 두 사람 중 괴도가 있는지 확인하는 권한을 가진다."),
    BEAUTY("미녀", "매 회차 한 사람을 유혹해 괴도인지 아닌지를 알 수 있지만 재판에서 투표를 할 수 없다."),
    GANG("깡패", "한 회차당 한 명의 마이크를 막을 수 있다."),
    AGENT("보안요원", "매 회차 한 명을 골라 몸 수색이 가능하다."),
    BANKPRESIDENT("은행장", "매 회차 A은행과 B은행 중 가짜 금괴와 진짜 금괴가 위치할 곳을 선택할 수 있다."),
    BANKCLERK("은행원", "매 회차 한번씩 다른 사람의 금고를 열어볼 수 있다. 항상 마지막 수색조에 배정된다."),
    // NONE의 경우 접속 시 부여받습니다.
    NONE("직업 없음", "정해진 직업이 없습니다.");

    public final static Map<Player, Jobs> jobMap = new HashMap<>();
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
        for (Player player : Bukkit.getOnlinePlayers()) jobMap.put(player, NONE);
    }

    // API 실행 시 Map에 이름과 직업을 매칭합니다.
    public static void register(){
        for (Jobs j : Jobs.values()) JOBNAME_TO_JOBS.put(j.jobName, j);
    }
}

package jinu.nulld.flow;

import org.bukkit.Bukkit;

public enum GameState {

    WAITING("게임 대기"),
    START("룰 설명"),
    SETTING("세팅"),
    SEARCH("수색"),
    DISCUSS("토론"),
    VOTING("투표"),
    JUDGE("재판"),
    NIGHT("밤");

    private final String name;

    GameState(String name){
        this.name = name;
    }

    public String getName() { return this.name; }


    private static GameState NOW_STATE = WAITING;

    private static final GameState[] STATE_ORDER = {
            WAITING,
            START,
            SETTING,
            SEARCH,
            DISCUSS,
            VOTING,
            JUDGE,
            NIGHT
    };

    /**
     * 현재 게임 상태를 불러옵니다.
     * 자세한 사항은 관리자 매뉴얼을 참고해주세요.
     * @return 현재 GameState
     */
    public static GameState getNowState(){ return NOW_STATE; }

    /**
     * 게임 진행 상황을 해당 GameState로 수정합니다.
     * GameStateChangeEvent를 발동시킵니다.
     * 사용을 권장하지 않으며, nextState()를 이용해주세요.
     * @param state 바꿀 GameState
     * @return 변경 성공 여부 (!event.isCancelled())
     */
    public static boolean setGameState(GameState state){
        GameStateChangeEvent event = new GameStateChangeEvent(NOW_STATE, state);
        Bukkit.getPluginManager().callEvent(event);

        if(!event.isCancelled()){
            NOW_STATE = state;
        }

        return !event.isCancelled();
    }

}

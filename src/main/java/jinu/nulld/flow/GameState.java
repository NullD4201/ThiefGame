package jinu.nulld.flow;

public enum GameState {

    WAITING("게임 대기"),
    START("룰 설명"),
    SETTING("세팅"),
    SEARCH("수색"),
    DISCUSS("토론"),
    JUDGE("재판");

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
            JUDGE
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

        if(!event.isCancelled()){
            NOW_STATE = state;
        }

        return !event.isCancelled();
    }

    /**
     * 게임을 다음 플로우로 진행시킵니다.
     * 순서는 해당 클래스의 STATE_ORDER 와 관리자 매뉴얼을 참고해주세요.
     * @param useJudgeAbility 판사 능력 사용 여부(재판 개정 여부)
     * @return 변경 성공 여부 (!event.isCancelled())
     */
    public static boolean nextState(boolean useJudgeAbility){
        GameState next = null;
        for(int i=0;i<STATE_ORDER.length;i++){
            if(STATE_ORDER[i] == NOW_STATE){
                // 재판이 열려야할 때 DISCUSS 단계면 JUDGE로, 아니면 바로 SETTING으로
                next = (i >= STATE_ORDER.length - (useJudgeAbility ? 1 : 2)) ? SETTING : STATE_ORDER[i+1];
                break;
            }
        }

        return setGameState(next);
    }

}

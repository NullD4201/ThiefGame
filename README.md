# **숨은 괴도 찾기 API**

## 빌드
[![](https://jitpack.io/v/nulld4201/ThiefGame.svg)](https://jitpack.io/#nulld4201/ThiefGame)

## 용법

### 직업 : 게임 직업 설정
```
Jobs.DETECTIVE          // 형사
Jobs.JUDGE              // 판사
Jobs.COUNSEL            // 검사
Jobs.BEAUTY             // 미녀
Jobs.GANG               // 깡패
Jobs.AGENT              // 보안요원
Jobs.BANKPRESIDENT      // 은행장
Jobs.BANKCLERK          // 은행원
Jobs.NONE               // 직업 없음
```

### 직업 : 직업 한글이름 및 설명 불러오기
```
Jobs._____.getJobName();
Jobs._____.getJobDescription();
```

### 능력 Event - Cancellable
```
AbilityStartUseEvent(Jobs job);
AbilityEndUseEvent(Jobs job);
```

### 게임 상태 변경 Event - Cancellable
```
GameStateChangeEvent(GameState oldState, GameState newState);
```

### 직업설정
```
JobAPI.setJob(Player p, Jobs j);
JobAPI.getJob(Player p);            // returns Jobs
```

### 직업 한글이름 -> 영문이름
```
JobAPI.getJobByName(String);
```

### 현재 게임 진행 상황 구하기
```
GameState.getNowState();
```

### 게임 진행 상황 다음 플로우로 넘기기
```
GameState.nextState(boolean useJudgeAbility);
```

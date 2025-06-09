# 🚀 BookBookClub-MSA


- **BookBookClub-MSA**는 책에 대한 생각을 자유롭게 공유할 수 있는 SNS 플랫폼 **BookBookClub**의 마이크로서비스 아키텍처(MSA) 버전입니다.
- 이 프로젝트는 기존 모놀리식 구조에서 출발하여 점진적으로 MSA로 전환 중이며, 서비스의 확장성과 유지보수성을 높이기 위해 분산 구조로 발전시켰습니다.


<br>

----

## 🏗️ 아키텍처 개요

- **기존 프로젝트**: [📎 BookBookClub (Monolith)](https://github.com/ddururiiiiiii/bookbookclub)
- **MSA 전환 목표**: 모놀리식에서 다음과 같은 마이크로서비스로 분리 진행

| 서비스                  | 설명                                             | 상태      |
|----------------------|------------------------------------------------|---------|
| User Service         | 회원 관리 (회원가입, 로그인, 프로필, 소셜 로그인 등) | ✅ 진행 중 |
| Post Service         | 피드 CRUD, 좋아요, 검색 등 게시글 관련 기능           | ✅ 진행 중 |
| Gateway Service      | API Gateway (요청 라우팅, 인증, 권한 처리)         | 🟠 예정    |
| Auth Service  | 인증/인가 및 JWT 관리 (Refresh/Access 관리 등)     | 🟠 예정    |

<br>

----
## 🔧 기술 스택

- **Backend**: Java, Spring Boot, JPA, QueryDSL
- **Infra**: Docker, Kubernetes(계획), Redis, Kafka(계획)
- **인증**: JWT, OAuth2 (Google, Naver)
- **CI/CD**: GitHub Actions (계획)
- **서비스간 통신**: REST API, Kafka(계획)

----

## 🔗 서비스별 깃허브 링크

- **User Service**: [🔗 링크](https://github.com/ddururiiiiiii/bbc-user-service)
- **Post Service**: [🔗 링크](https://github.com/ddururiiiiiii/bbc-post-service)
- **Gateway Service**: [🔗 링크] (예정)

----

## 📕 개발일지
** 링크를 클릭하면 개발일지를 작성한 블로그로 이동 됩니다.

### 회원 (로그인/회원가입/로그아웃)
- [#000 프로젝트 생성 (프로젝트 생성, MySQL 연결, 개발 편의 설정, 패키지 설정 등)](https://ddururiiiiiii.tistory.com/598)
- [#001 회원 도메인(User) 개발](https://ddururiiiiiii.tistory.com/604)
- [#002 회원(User) 도메인 단위 테스트](https://ddururiiiiiii.tistory.com/605)
- [#003 회원(User) 도메인 회원가입 API 구현 + 테스트](https://ddururiiiiiii.tistory.com/608)
- [#004 회원 정보 수정 API 구현](https://ddururiiiiiii.tistory.com/610)
- [#005 로그인 구현 (Feat.JWT 기반 인증)](https://ddururiiiiiii.tistory.com/611)
- [#006 회원가입 전, 이메일 인증 구현](https://ddururiiiiiii.tistory.com/613)
- [#007 로그인 구현2 (refreshToken 도입) / 로그아웃](https://ddururiiiiiii.tistory.com/614)
- [#008 로그인 구현3 (refreshToken 재발급, AccessToken 블랙리스트 기능)](https://ddururiiiiiii.tistory.com/615)
- [#009 회원탈퇴 구현 (Spring Scheduler)](https://ddururiiiiiii.tistory.com/616)
- [#010 회원가입 수정 (6개월 이내 재가입 불가능)](https://ddururiiiiiii.tistory.com/617)
- [#011 Oauth 로그인 구현 (구글)](https://ddururiiiiiii.tistory.com/618)
- [#012 Oauth 로그인 구현 (네이버)](https://ddururiiiiiii.tistory.com/619)
- [#013 회원 프로필 사진 등록 기능 구현](https://ddururiiiiiii.tistory.com/620)
- [#014 글로벌 예외처리 및 API 응답 포맷 통일](https://ddururiiiiiii.tistory.com/621)
- [#015 이메일 인증 실패 시도 횟수 제한 기능](https://ddururiiiiiii.tistory.com/623)

### 책(Book)
- [#016 북(Book) 도메인 개발 및 단위 테스트](https://ddururiiiiiii.tistory.com/637)
- [#017 북(Book) 도메인 API 구현 및 테스트](https://ddururiiiiiii.tistory.com/639)
- [#029 책(Book) - Spring WebClient로 외부 API 연동: KakaoBookClient 구현](https://ddururiiiiiii.tistory.com/653)
- [#033 책(Book) 중복 등록 시 예외 처리 하기](https://ddururiiiiiii.tistory.com/658)

### 피드(Feed)
- [#018 피드(Feed) 도메인 개발 및 단위테스트](https://ddururiiiiiii.tistory.com/640)
- [#019 피드(Feed) 도메인 API 구현 및 테스트](https://ddururiiiiiii.tistory.com/641)
- [#026 신고(Report) 도메인 구현 및 단위테스트](https://ddururiiiiiii.tistory.com/650)
- [#027 신고(Report) 누적 시, 블라인드 처리](https://ddururiiiiiii.tistory.com/651)
- [#028 좋아요 순 피드 조회 (주간/월간/연간/누적)](https://ddururiiiiiii.tistory.com/652)
- [#030 좋아요(Like) 랭킹에서 피드 상세정보 함께 내려주기](https://ddururiiiiiii.tistory.com/654)
- [#031 피드 검색 조회](https://ddururiiiiiii.tistory.com/656)
- [#032 각종 피드 조회 (특정 회원의 피드 목록 조회, 특정 회원이 좋아요 누른 피드 목록 조회)](https://ddururiiiiiii.tistory.com/657)

### 좋아요(Like)
- [#020 좋아요(Like) 도메인 개발 및 단위테스트](https://ddururiiiiiii.tistory.com/642)
- [#021 좋아요(Like) 도메인 API 구현 및 테스트](https://ddururiiiiiii.tistory.com/643)
- [#025 좋아요(Like) 토글 기능으로 변경하기](https://ddururiiiiiii.tistory.com/648)

### 댓글(Comment)
- [#022 댓글(Comment) 도메인 구현 및 단위테스트](https://ddururiiiiiii.tistory.com/644)
- [#023 댓글(Comment) API 구현 및 테스트](https://ddururiiiiiii.tistory.com/645)
- [#024 JWT 토큰이 없는데도 200 OK 가 뜬다? (해결방법)](https://ddururiiiiiii.tistory.com/646)

### 팔로우(Follow)
- [#034 팔로우(Follow) 도메인 구현 및 테스트](https://ddururiiiiiii.tistory.com/659)

### MAS 전환기
- [#035 모놀리식 아키텍처를 MSA 아키텍처로 전환하기 (1) - bbc-user-service (User, EmailValidation 엔티티)
](https://ddururiiiiiii.tistory.com/662)
- [#036 모놀리식 아키텍처를 MSA 아키텍처로 전환하기 (2) - bbc-user-service ((Follow 엔티티)](https://ddururiiiiiii.tistory.com/665)
- [#037 모놀리식 아키텍처를 MSA 아키텍처로 전환하기 (3) - MSA 환경에서의 서비스 간 통신 구축](https://ddururiiiiiii.tistory.com/673)

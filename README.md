# 📚 BookBookClub-MSA

> "책 덕질도 트위터처럼!"  
> BookBookClub은 책에 대한 생각과 감상을 자유롭게 공유할 수 있는 SNS 플랫폼입니다.  
> 이 프로젝트는 기존 모놀리식 구조를 MSA로 전환하여 확장성과 유지보수성을 높이기 위해 진행 중입니다.

<br>

----

## 🏗️ 프로젝트 개요

- **프로젝트 이름**: BookBookClub-MSA
- **진행 기간**: 2025.04.16 ~ 진행 중
- **목표**: 실무에서 경험하기 어려운 기술들(OAuth2, Redis, Kafka, MSA 등)을 활용한 사이드 프로젝트 구축 및 운영 경험

<br>

----


## ⚙️ 기술 스택

| 분류           | 기술 목록                                                                 |
|----------------|--------------------------------------------------------------------------|
| Language       | Java 17, Kotlin (예정)                                                   |
| Framework      | Spring Boot, Spring Security, Spring Cloud, JPA, QueryDSL                |
| Build Tool     | Gradle                                                                   |
| Infra          | MySQL, Redis (토큰/랭킹 캐시), Kafka (예정), Docker, Kubernetes (예정)   |
| 인증 및 보안   | JWT, OAuth2 (Google, Naver 지원 완료)                                     |
| API 통신       | OpenFeign, RestTemplate (QueryDSL 적용 중)                               |
| 배포 자동화     | GitHub Actions (예정), CI/CD 구조 설계 중                                |

<br>

----

## 🧱 멀티모듈 구조

```bash
📁 BookBookClub-MSA
├── bbc-user-service # 회원 서비스 (로그인, 프로필, 소셜 로그인 등)
├── bbc-post-service # 게시글 서비스 (피드 CRUD, 좋아요 등)
├── bbc-common # 공통 DTO, Response, 예외 처리 등
└── (추후 추가 예정) # gateway-service, batch-service, notification-service 등
```

<br>

----


## ✅ 구현 완료 기능

### 공통
- [x] 멀티모듈 기반 MSA 프로젝트 구조 정리
- [x] 공통 ErrorCode, Response 통일
- [x] Feign Client 연동 (User → Post 간 인증 정보 전달)

### 유저 서비스 (`bbc-user-service`)
- [x] JWT 기반 인증/인가 (Access/Refresh Token 구조)
- [x] 소셜 로그인 (Google, Naver)
- [x] 이메일 인증 + Redis 저장 + DB 기록
- [x] 사용자 정보 조회 (마이페이지)
- [x] 프로필 이미지 업로드 (로컬 저장, S3 예정)
- [x] 회원 탈퇴 (refreshToken 삭제, accessToken 블랙리스트 등록 포함)
- [x] 로그아웃 기능 (refresh 제거 + accessToken 블랙리스트 등록)
- [x] 탈퇴 후 재가입 제한 정책 적용

### 게시글 서비스 (`bbc-post-service`)
- [x] 피드 CRUD
- [x] 좋아요 토글, 좋아요 수 조회
- [x] 인기 피드 Redis 기반 랭킹 캐시
- [x] QueryDSL 기반 검색 기능
- [x] 블라인드 처리된 피드 제외 로직
- [x] MSA 환경에서 사용자 정보 연동 (Feign 사용)

<br>

----

## 🪜 향후 계획

- [ ] 관리자 페이지 (Spring Security + Admin Dashboard)
- [ ] Kafka 기반 피드 이벤트 처리 및 통계 수집
- [ ] Redis 기반 세션 및 랭킹 초기화 스케줄링
- [ ] API Gateway 도입 + Spring Cloud Gateway
- [ ] CI/CD 자동화 (GitHub Actions → AWS)
- [ ] Android 앱 (Kotlin + Jetpack Compose)

<br>

----

## 📌 프로젝트 링크

- **🧱 모놀리식 버전**: [BookBookClub (Monolith)](https://github.com/ddururiiiiiii/bookbookclub)
- **📁 MSA 버전**: [BookBookClub-MSA](https://github.com/ddururiiiiiii/BookBookClub-MSA)
- **📄 도메인별 **:
-   [bbc-user-service](https://github.com/ddururiiiiiii/bbc-user-service)
-   [bbc-post-service](https://github.com/ddururiiiiiii/bbc-post-service)


<br>

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
- [#040 리팩토링 - (2) User 도메인 (단위 테스트, Postman 테스트 포함)](https://ddururiiiiiii.tistory.com/676)

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
- [#042 리팩토링 - (4) Feed 도메인 (단위 테스트, Postman 테스트 포함)](https://ddururiiiiiii.tistory.com/680)

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
- [#041 리팩토링 - (3) Follow 도메인 (단위 테스트, Postman 테스트 포함)](https://ddururiiiiiii.tistory.com/679)

### MAS 전환기
- [#035 모놀리식 아키텍처를 MSA 아키텍처로 전환하기 (1) - bbc-user-service (User, EmailValidation 엔티티)
](https://ddururiiiiiii.tistory.com/662)
- [#036 모놀리식 아키텍처를 MSA 아키텍처로 전환하기 (2) - bbc-user-service ((Follow 엔티티)](https://ddururiiiiiii.tistory.com/665)
- [#037 모놀리식 아키텍처를 MSA 아키텍처로 전환하기 (3) - MSA 환경에서의 서비스 간 통신 구축](https://ddururiiiiiii.tistory.com/673)
- [#038 공통모듈 구조 만들기, 예외 처리 분리하기](https://ddururiiiiiii.tistory.com/674)
- [#039 리팩토링 - (1) 공통 응답 구조, 공통 예외 처리](https://ddururiiiiiii.tistory.com/675)
- [#043 리팩토링 (5) - CustomUserDetails, FeignClient 그리고 record](https://ddururiiiiiii.tistory.com/681)
# springboot-project-board

## 개발 목적 이해하기

### 서비스 고도화 프로젝트의 목표
- 기존 서비스 프로젝트의 목표를 그대로 이어간다.
- 기존 프로젝트에서 발전 가능한 아이디어를 고민한다.
- 새로운 아이디어를 구현하여 프로젝트를 발전시키는 경험을 한다.

### 고객의 새로운 문제 정의와 해결
- DB Migration
- 대댓글 기능
- 해시태그 기능 개선
- 카카오톡 로그인 (OAuth 2.0) 연동
- 기능 배포 결정과 취소 (롤백)
- Hashicorp Vault
- Swagger UI

### 변경된 도구 버전들
- IDE : IntelliJ 2022.2 (Ultimate Edition)
- Language : Java 17 (이전과 동일)
- Framework : Spring Boot 2.7.0 (이전과 동일)
- Build Tool : Gradle 7.4.1 (이전과 동일)
- Git GUI : GitKraken 8.8.0

<hr>

## 필요한 기술 정리

### 예상하는 세부 기능들
- 대댓글 도메인의 설계
- 해시태그 기능 개선을 위한 게시글 도메인의 수정 여부 검토
- 관련 비지니스 로직과 테스트 변경
- 인증 기능 업데이트 : OAuth 2.0 + Kakao 로그인
- 웹 화면 변경
    - 게시판 페이지 : 대댓글 표현
    - 로그인 페이지 : Kakao 로그인 화면으로 변경 [공식 문서 링크](https://developers.kakao.com)
- 추가 의존성 조사 및 선책
    - Spring Initializer - OAuth2 Client [공식 문서 링크](https://start.spring.io), Vault Configuration [공식 문서 링크](https://vaultproject.io)
    - Swagger UI - Springdoc-openapi [공식 문서 링크](https://springdoc.org)

### DB Migration (MySQL -> PostgreSQL)
```shell
# PostgreSQL 설치 (MacOS)
brew install postgresql

# 설치된 DB 패키지 버전 조회
brew list | grep sql

# PostgreSQL 실행
brew start service postgresql@14

# PostgreSQL DB 접속 (Default 계정명은 사용자 로컬 ID 명)
psql postgres primarch

# DB 사용자 조회
select * from pg_user;

# DB 생성
create database board;

# List of roles
\du

# List of databases
\l

# List of relation
\d

# 특정 DB 로 접속
\c board

# DB 연결 종료
\q

# 접속 정보 조회
\conninfo

# DB 사용자 생성
create user {사용자명} with password '{비밀번호}';
```


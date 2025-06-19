#!/bin/bash

# 서비스 목록 정의
SERVICES=("user-service" "post-service" "notification-service" "gateway")

echo "🔨 Gradle bootJar 빌드 시작 (전체 서비스)"
for SERVICE in "${SERVICES[@]}"
do
  echo "👉 빌드 중: bbc-$SERVICE"
  ./gradlew ":bbc-$SERVICE:bootJar"
  if [ $? -ne 0 ]; then
    echo "❌ Gradle 빌드 실패: bbc-$SERVICE"
    exit 1
  fi
done

echo "🐳 Docker Compose 전체 서비스 재빌드 & 실행"
docker compose up --build

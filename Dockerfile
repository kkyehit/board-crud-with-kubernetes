#1. openjdk 11
FROM        openjdk:11

#2. 이름 입력 (안해도 됨)
MAINTAINER  huijun

#3. 컨테이너에 저장하지 않고 호스트에 저장
VOLUME      C:\dockerImage\board

#4. 컨테이너 외부로 노출할 포트 설정
EXPOSE      8080

#5. 빌드된 파일 이름
ARG         JAR_FILE=./target/board-0.0.1-SNAPSHOT.jar

#6. 컨테이너에 파일 추가
ADD         ${JAR_FILE} board.jar

#7. 파일 실행
ENTRYPOINT  ["java","-jar","/board.jar"]


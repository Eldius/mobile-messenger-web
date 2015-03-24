cls

call mvn clean install -DskipTests=true
if NOT "%ERROR_CODE%" == "0" GOTO ERROR

set "MAVEN_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"
call mvn jetty:run

GOTO FINISH

:ERROR
msg * ERROR EXIT CODE: "%ERROR_CODE%"

:FINISH

set "MAVEN_OPTS="

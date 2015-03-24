cls

set "MAVEN_OPTS="
call mvn clean install -Ptest-profile
if NOT "%ERROR_CODE%" == "0" GOTO ERROR
GOTO FINISH

:ERROR
msg * ERROR EXIT CODE: "%ERROR_CODE%"

:FINISH
echo Finished!


@echo off
title API Gateway
echo Iniciando o API Gateway...

set PROJECT_DIR=%~dp0..\src\backend\ms_gateway
cd /d "%PROJECT_DIR%"

echo Compilando o projeto...
call mvn clean package -DskipTests

if %errorlevel% neq 0 (
    echo Erro na compilacao!
    pause
    exit /b 1
)

echo Executando a aplicacao...
java -jar target\ms_gateway-0.0.1-SNAPSHOT.jar

pause
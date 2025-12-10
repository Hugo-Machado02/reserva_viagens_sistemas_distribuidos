@echo off
title MS Reservas
echo Iniciando o Servico de Reservas...

set PROJECT_DIR=%~dp0..\src\backend\ms_reservas
cd /d "%PROJECT_DIR%"

echo Compilando o projeto...
call mvn clean package -DskipTests

if %errorlevel% neq 0 (
    echo Erro na compilacao!
    pause
    exit /b 1
)

echo Executando a aplicacao...
java -jar target\ms_reservas-0.0.1-SNAPSHOT.jar

pause
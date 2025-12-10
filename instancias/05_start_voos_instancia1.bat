@echo off
title MS Voos - Instancia 1
echo Iniciando o Servico de Voos (Instancia 1)...

set PROJECT_DIR=%~dp0..\src\backend\ms_voos
cd /d "%PROJECT_DIR%"

echo Compilando o projeto...
call mvn clean package -DskipTests

if %errorlevel% neq 0 (
    echo Erro na compilacao!
    pause
    exit /b 1
)

echo Executando a aplicacao...
java "-Dspring.profiles.active=instance1" -jar target\ms_voos-0.0.1-SNAPSHOT.jar

pause
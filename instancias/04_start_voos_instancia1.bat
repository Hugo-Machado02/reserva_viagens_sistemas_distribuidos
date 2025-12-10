@echo off
echo Iniciando o Servico de Voos (Instancia 1)...

mvn -f "..\src\backend\ms_voos\pom.xml" spring-boot:run "-Dspring-boot.run.profiles=instance1"
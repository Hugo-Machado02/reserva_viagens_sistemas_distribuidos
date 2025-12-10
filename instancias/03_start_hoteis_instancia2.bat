@echo off
echo Iniciando o Servico de Hoteis (Instancia 2)...

mvn -f "..\src\backend\ms_hoteis\pom.xml" spring-boot:run "-Dspring-boot.run.profiles=instance2"
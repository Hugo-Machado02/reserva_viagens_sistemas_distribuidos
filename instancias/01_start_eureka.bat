@echo off
echo Iniciando o Servico do Eureka...

mvn -f "..\src\backend\ms_eureka\pom.xml" spring-boot:run
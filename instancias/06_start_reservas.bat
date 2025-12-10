@echo off
echo Iniciando o Servico de Reservas

mvn -f "..\src\backend\ms_reservas\pom.xml" spring-boot:run
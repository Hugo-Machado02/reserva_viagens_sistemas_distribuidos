@echo off
title Iniciando Todos os Microsservicos
echo ========================================
echo    SISTEMA DE RESERVA DE VIAGENS
echo    Iniciando todos os microsservicos
echo ========================================
echo.

echo [1/8] Iniciando Eureka Server...
start "Eureka Server" cmd /c "%~dp0\01_start_eureka.bat"
timeout /t 15 /nobreak >nul

echo [2/8] Iniciando API Gateway...
start "API Gateway" cmd /c "%~dp0\02_start_gateway.bat"
timeout /t 10 /nobreak >nul

echo [3/8] Iniciando MS Hoteis - Instancia 1...
start "MS Hoteis - Instancia 1" cmd /c "%~dp0\03_start_hoteis_instancia1.bat"
timeout /t 10 /nobreak >nul

echo [4/8] Iniciando MS Hoteis - Instancia 2...
start "MS Hoteis - Instancia 2" cmd /c "%~dp0\04_start_hoteis_instancia2.bat"
timeout /t 5 /nobreak >nul

echo [5/8] Iniciando MS Voos - Instancia 1...
start "MS Voos - Instancia 1" cmd /c "%~dp0\05_start_voos_instancia1.bat"
timeout /t 10 /nobreak >nul

echo [6/8] Iniciando MS Voos - Instancia 2...
start "MS Voos - Instancia 2" cmd /c "%~dp0\06_start_voos_instancia2.bat"
timeout /t 5 /nobreak >nul

echo [7/8] Iniciando MS Reservas...
start "MS Reservas" cmd /c "%~dp0\07_start_reservas.bat"
timeout /t 10 /nobreak >nul

echo [8/8] Iniciando Frontend Gateway...
start "Frontend Gateway" cmd /c "%~dp0\08_start_frontend.bat"

echo.
echo ========================================
echo   TODOS OS SERVICOS FORAM INICIADOS!
echo ========================================
echo.
echo Servicos rodando:
echo - Eureka Server: http://localhost:8761
echo - MS Hoteis: http://localhost:8082
echo - MS Voos: http://localhost:8081  
echo - MS Reservas: http://localhost:8083
echo - Frontend: http://localhost:5173
echo.
echo Pressione qualquer tecla para fechar...
pause >nul
@echo off
echo Iniciando o Gateway (Frontend)...

cd "..\src\frontend\gateway"

echo Verificando dependencias...
call npm install

echo Iniciando servidor...
npm run dev
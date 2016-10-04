@echo off
:: Con :: se establecen comentarios
::set se definen variables
set workspace=C:\ProyectosMIW\Klondike.Hector.Lozano
::Las variables de entorno se pueden configurar directamente en Windows cuando se tienen los permisos necesarios
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_91
set M2_HOME=C:\Users\Jahir\Desktop\MIW-Proyectos\apache-maven-3.3.9
:: %var% se accede a una variable
set PATH=%PATH%;%JAVA_HOME%\bin;%M2_HOME%\bin
::echo saca por pantalla un mensaje
echo -----------------------------------------
echo . (C) MIW
echo -----------------------------------------
echo .
echo Workspace --- %workspace%
echo JAVA_HOME --- %JAVA_HOME%
echo M2_HOME   --- %M2_HOME%
echo .
cd %workspace%
echo ==== :: Se ejecuta un comando maven: mvn clean test (profile: develop) =======
call mvn clean test 
echo .
::Se queda la consola abierta para realizar comandos en línea
cmd /k
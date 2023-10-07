@echo off

rem Navigate to the Spring Boot project directory
cd "backend"

rem Start the Spring Boot application using Gradle
start /min cmd /k "gradlew.bat bootRun"

rem Open a new command prompt window and navigate to the Angular project directory
cd "..\ui\frontend"
start /min cmd /k "ng serve"


@echo off

rem find the JAVA installation path
for /f "skip=2 tokens=2*" %%A in ('REG QUERY "HKLM\Software\JavaSoft\Java Development Kit" /v CurrentVersion') do set CurVer=%%B

for /f "skip=2 tokens=2*" %%A in ('REG QUERY "HKLM\Software\JavaSoft\Java Development Kit\%CurVer%" /v JavaHome') do set JAVA_HOME=%%B

rem compile and run the program
set javac="%JAVA_HOME%\bin\javac.exe"
set java="%JAVA_HOME%\bin\java.exe"

rem find all java files including subfolders then compile
for /r . %%A in (*.java) do (
	cd "%%~dpA"
	%javac% -d . %%~nxA
	rem find all java classes including subfolders then run
	for /r . %%B in (*.class) do (
	    if "%%~nA"=="%%~nB" (
			if "%%~dpA"=="%%~dpB" %java% %%~nA
			if not "%%~dpA"=="%%~dpB" (
				for /f "tokens=2* delims=; " %%C in ('findstr /i "package" "%%~nxA"') do %java% %%C.%%~nA
			)
		)		
	)
)

pause
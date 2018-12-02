all: pre1 pre2

run1:
	java -jar Pregunta1.jar

run2:
	java -jar Pregunta2.jar

pre1: classes1
	jar cfm Pregunta1.jar src/manifest1.mf -C build/classes .
pre2: classes2
	jar cfm Pregunta2.jar src/manifest2.mf -C build/classes .


classes1: dir
	javac -sourcepath src/ -d build/classes src/Pregunta_1/*.java
classes2: dir
	javac -sourcepath src/ -d build/classes src/Pregunta_2/*.java

dir:
	if [ ! -d build/classes ]; then mkdir -p build/classes; fi
	if [ ! -d build/jar ]; then mkdir -p build/jar; fi
clean:
	if [ -d build ]; then rm build -R; fi
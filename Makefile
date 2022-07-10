source := $(wildcard src/*.java)

run: compile
	java -cp bin:lib/commons-io-1.3.2.jar Main

doc:
	javadoc -d docs -cp docs:lib/commons-io-1.3.2.jar src/*.java

compile: $(source)
	javac -d bin -cp bin:lib/commons-io-1.3.2.jar src/*.java

clean:
	rm -r docs/* bin/*.class

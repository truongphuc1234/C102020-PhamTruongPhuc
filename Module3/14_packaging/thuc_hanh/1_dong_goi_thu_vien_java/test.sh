rm -rf build/test/
mkdir build/test/
cd src/main/
$JAVA_HOME/bin/javac org/usefullibs/greeter/impl/HelloWorld.java -d ../../build/test/ && echo 'Compiled org.usefullibs.greeter.impl.HelloWorld class!'
cd ../test/
$JAVA_HOME/bin/javac org/usefullibs/greeter/impl/HelloWorldTest.java -cp ../../build/test/:../../libs/junit-4.11.jar -d ../../build/test/ && echo 'Compiled org.usefullibs.greeter.impl.HelloWorldTest class!'
cd ../../build/test
$JAVA_HOME/bin/java -cp ../../libs/junit-4.11.jar:../../libs/hamcrest-core-1.3.jar:. \
  org.junit.runner.JUnitCore \
  org.usefullibs.greeter.impl.HelloWorldTest

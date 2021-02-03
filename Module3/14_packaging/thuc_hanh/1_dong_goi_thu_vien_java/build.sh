rm -rf build/main
mkdir build/main
cd src/main
$JAVA_HOME/bin/javac org/usefullibs/greeter/impl/HelloWorld.java -d ../../build/main/ && echo 'Compiled org.usefullibs.greeter.impl.HelloWorld class!'
cd ../../build/main
$JAVA_HOME/bin/jar cvf greeting.jar org/usefullibs/greeter/Greeter.class org/usefullibs/greeter/impl/HelloWorld.class

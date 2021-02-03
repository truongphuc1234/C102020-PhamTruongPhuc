package org.usefullibs.greeter.impl;
import org.usefullibs.greeter.Greeter;

public class HelloWorld implements Greeter {
  @Override
  public String greet() {
    return "HelloWorld !";
  }
}	

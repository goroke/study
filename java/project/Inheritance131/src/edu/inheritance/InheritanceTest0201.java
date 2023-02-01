package edu.inheritance;

class A{A(){System.out.println('A');}}
class B extends A{B(){System.out.println('B');}}
class C extends B{C(){System.out.println('C');}}

public class InheritanceTest0201 {
	A a = new A();
}

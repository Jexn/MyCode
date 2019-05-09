package Apr27;

public class A {
    public A foo(){
        return this;
    }
}

class B extends A{
    public A foo(){
        return this;
    }
}

class C extends B{
    public void foo(B b){
    }
}

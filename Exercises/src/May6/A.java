package May6;

class C {
    C() {
        System.out.print("C");
    }
}

class A {
    C c = new C();

    A() {
        this("A");
        System.out.print("A");
    }

    A(String s) {
        System.out.print(s);
    }
}

class Test extends A {
    Test() {
        super("B");
        System.out.print("B");
    }

    public static void main(String[] args) {
        new Test();
        byte a1 = 2, a2 = 4, a3;
        short s = 16;
        a2 = s;
        a3 = a1 * a2;
    }
}


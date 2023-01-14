package sem1.tsk2;

class A {
    int i;
}

class B extends A {
    int i; // this variable of current class B

    B(int a, int b) {
        super.i = a; //variables i from class A. super link to variables i from A
        this.i = b;
    }

    void show() {
        System.out.println("i in superClass " + super.i);
        System.out.println("i in subClass " + this.i);
    }
}

class Test {
    public static void main(String[] args) {
        B objB = new B(1,4);

        objB.show();
        B objB2 = new B(3,4);
        objB2.show();
        objB.show();
    }
}
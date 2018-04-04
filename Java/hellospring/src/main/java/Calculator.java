public class Calculator {
    Calculator(int a, int b){
        this.a = a;
        this.b = b;
    }

    int add(){
        return a+b;
    }

    int subtr(){
        return a-b;
    }

    int multiply(){
        return a*b;
    }

    double divide(){
        return a/b;
    }

    int a;
    int b;
}

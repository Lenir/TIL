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

    double divide() throws Exception{
        if(b == 0){
            throw new Exception("Divie by zero exception");
        }
        return ((double)a)/((double)b);
    }

    int a;
    int b;
}

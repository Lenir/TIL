import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void addTest(){
        Calculator calc = new Calculator(6, 3);
        assertEquals(9, calc.add());
    }

    @Test
    void subtrTest(){
        Calculator calc = new Calculator(6, 3);
        assertEquals(3, calc.subtr());
    }

    @Test
    void subtrTest_minus(){
        Calculator calc = new Calculator(3, 6);
        assertEquals(-3, calc.subtr());
    }

    @Test
    void multiTest(){
        Calculator calc = new Calculator(3, 6);
        assertEquals(18, calc.multiply());
    }

    @Test
    void divideTest_noRemainer(){
        Calculator calc = new Calculator(6, 3);
        try {
            assertEquals(2, calc.divide());
        }catch (Exception e){}
    }

    @Test
    void divideTest_withRemainer(){
        Calculator calc = new Calculator(6, 5);
        try {
            assertEquals(1.2, calc.divide(), 0.000000001);
        }catch (Exception e){
        }
    }

    @Test
    void divideTest_divByZero(){
        Calculator calc = new Calculator(6, 0);
        try {
            assertThrows(Exception.class, ()->{
                calc.divide();
            });
        }catch (Exception e){}

    }


}
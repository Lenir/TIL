import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExchangeTest {
	double doubleDelta = 0.0000000001;
	@Test
	public void testAdd() {
		Dollar one = new Dollar(1);
		one.add(2);
		assertEquals(3, one.amount, doubleDelta);
	}
	
	@Test
	public void testFloatingAdd() {
		Dollar one = new Dollar(1.1);
		one.add(2.2);
		assertEquals(3.3, one.amount, doubleDelta);
	}
	
	@Test
	public void testExchange() {
		Won fifteenH = new Won(1500);
		Dollar one = new Dollar(1);
		fifteenH.add(one);
		assertEquals(3000, fifteenH.amount);
	}
	
	@Test
	public void testExchangeFloat() {
		Won fifteenH = new Won(1500);
		Dollar one = new Dollar(1.5);
		fifteenH.add(one);
		assertEquals(3750, fifteenH.amount, doubleDelta);
	}
	
	@Before
	public void beforeTest() {
		System.out.println("Test Begins!");
	}
	@After
	public void afterTest() {
		System.out.println("Test End..");
	}

}
class Dollar{
	double amount;
	int wonExRate = 1500;
	Dollar(double _amount){
		amount = _amount;
	}
	void add(double adder) {
		amount += adder;
	}
}

class Won{
	int amount;
	Won(int _amount){
		amount = _amount;
	}
	void add(Dollar adder) {
		amount += adder.amount * adder.wonExRate;
	}
}

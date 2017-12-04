import static org.junit.Assert.*;

import java.util.*;

import javax.swing.event.ListSelectionEvent;

import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {
	private ArrayList<Integer> target;
	private ArrayList<Integer> answer;
	@Before
	public void setUp() {
		target = new ArrayList<Integer>(Arrays.asList(2, 5, 1, 3, 4, 7, 6));
		answer = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
	}
	@Test
	public void qSortTest() {
		Qsort.qsort(target);
		assertEquals(answer, target);
	}
}
class Qsort{
	static int getPivot(ArrayList<Integer> target) {
		if(target.size() >= 3) {
			int end = target.get(target.size()-1);
			int mid = target.get(target.size()/2);
			int fir = target.get(0);
			return (int)Math.max(Math.min(fir, mid), Math.min(fir, end));
		}else{
			return target.get(0);
		}
	}
	static void qsort(ArrayList<Integer> target) {
		ArrayList<Integer> less = new ArrayList<Integer>();
		ArrayList<Integer> equal = new ArrayList<Integer>();
		ArrayList<Integer> large = new ArrayList<Integer>();
		int pivot;
		pivot = getPivot(target);
		if(target.size() > 1) {
			for(int element: target) {
				if(element > pivot) {
					large.add(element);
				}else if(element < pivot) {
					less.add(element);
				}else {
					equal.add(element);
				}
			}
			if(less.size() > 0) {
				Qsort.qsort(less);
			}
			if(equal.size() > 0) {
				Qsort.qsort(equal);
			}
			if(large.size() > 0) {
				Qsort.qsort(large);
			}
			target.clear();
			target.addAll(less);
			target.addAll(equal);
			target.addAll(large);
		}
	}
}
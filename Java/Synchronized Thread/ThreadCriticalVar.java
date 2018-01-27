
public class ThreadCriticalVar {
	private int criticalVar = 0;
	
	ThreadCriticalVar(){
	}
	
	synchronized void syncIncrease1() {
		this.criticalVar += 1;
	}
	
	void asyncIncrease1() {
		this.criticalVar += 1;
	}
	
	int getCriticalVar() {
		return(this.criticalVar);
	}
	
	
}



import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainThread {
	public static void main(String[] args) {
		ThreadCriticalVar threadSafeClass = new ThreadCriticalVar();
		ThreadCriticalVar threadUnsafeClass = new ThreadCriticalVar();
		
		SafeThread safeRunnable = new SafeThread(threadSafeClass);
		SafeThread safeRunnable2 = new SafeThread(threadSafeClass);
		SafeThread safeRunnable3 = new SafeThread(threadSafeClass);
		
		
		
		UnsafeThread unsafeRunnable = new UnsafeThread(threadUnsafeClass);
		UnsafeThread unsafeRunnable2 = new UnsafeThread(threadUnsafeClass);
		UnsafeThread unsafeRunnable3 = new UnsafeThread(threadUnsafeClass);
		
		Thread safeThread = new Thread(safeRunnable);
		Thread safeThread2 = new Thread(safeRunnable2);
		Thread safeThread3 = new Thread(safeRunnable3);
		
		Thread unsafeThread = new Thread(unsafeRunnable);
		Thread unsafeThread2 = new Thread(unsafeRunnable2);
		Thread unsafeThread3 = new Thread(unsafeRunnable3);
		
		safeThread.start();
		safeThread2.start();
		safeThread3.start();
		
		unsafeThread.start();
		unsafeThread2.start();
		unsafeThread3.start();
		
		try {
			safeThread.join();
			safeThread2.join();
			safeThread3.join();
			
			unsafeThread.join();
			unsafeThread2.join();
			unsafeThread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(threadSafeClass.getCriticalVar() + " " + threadUnsafeClass.getCriticalVar());

	}
}


class UnsafeThread implements Runnable{
	
	private ThreadCriticalVar criticalClass;
	
	UnsafeThread(ThreadCriticalVar criticalClass){
		this.criticalClass = criticalClass;
	}
	
	@Override
	public void run() {
		for(int i=0; i<100000; i++) {
			this.criticalClass.asyncIncrease1();
		}
	}
}


class SafeThread implements Runnable{
	
	private ThreadCriticalVar criticalClass;
	
	SafeThread(ThreadCriticalVar criticalClass){
		this.criticalClass = criticalClass;
	}
	
	@Override
	public void run() {
		for(int i=0; i<100000; i++) {
			this.criticalClass.syncIncrease1();
		}
	}
}
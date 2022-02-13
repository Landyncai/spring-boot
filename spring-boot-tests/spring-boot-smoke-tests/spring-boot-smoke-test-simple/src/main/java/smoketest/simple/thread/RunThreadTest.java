package smoketest.simple.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunThreadTest {

	public static void main(String[] args) {
		System.out.println("1 Thread.activeCount(); = " + Thread.activeCount());
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.execute(()->{
			System.out.println("2 Thread.activeCount(); = " + Thread.activeCount());
			System.out.println("Service Thread.currentThread().isInterrupted() = " + Thread.currentThread().isInterrupted());
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			Thread.currentThread().interrupt();
			// 任务一直跑
			while (!Thread.currentThread().isInterrupted()) {
				Thread.currentThread().interrupt();
				System.out.println("Service while Thread.currentThread().isInterrupted() = " + Thread.currentThread().isInterrupted());
				System.out.println("1");
				System.out.println("5 Thread.activeCount(); = " + Thread.activeCount());
			}
		});
		try {
			Thread.sleep(3000);
//			System.out.println("Thread.currentThread().isInterrupted() = " + Thread.currentThread().isInterrupted());
//			Thread.currentThread().interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("executorService.shutdownNow");
		System.out.println("3 Thread.activeCount(); = " + Thread.activeCount());
		executorService.shutdownNow();
		System.out.println("4 Thread.activeCount(); = " + Thread.activeCount());
	}

}

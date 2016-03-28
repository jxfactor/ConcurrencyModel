package week1.day2;
public class Uninterruptible {
	public static void main(String[] args) throws InterruptedException{
		final Object o1 = new Object();
		final Object o2 = new Object();
		
		Thread t1 = new Thread() {
			public void run() {
				try {
					synchronized(o1) {
						Thread.sleep(1000);
						synchronized(o2) {}
					}
				} catch (InterruptedException e) {
					
					System.out.println("t1 interrupted");
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				try {
					synchronized(o2) {
						Thread.sleep(1000);
						synchronized(o1) {}
					}
				} catch (InterruptedException e) {
					
					System.out.println("t2 interrupted");
				}
			}
		};
		
		t1.start();
		t2.start();
		Thread.sleep(1000);
		
		// 使用内置锁时，由于阻塞的线程无法被中断，程序也就不可能从死锁中恢复，唯一的办法就是终止JVM
		
		t1.interrupt();
		t2.interrupt();
		
		t1.join();
		t2.join();
	}
}

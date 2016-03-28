package week1.day1;
public class CountingSynchronized {
	public static void main(String[] args) throws InterruptedException{
		class Counter {
			private int count = 0;
			// 竞态条件的解决方案是对访问对象进行同步访问
			// 一种方法是使用Java对象原生的内置锁来同步对increment()的调用
			public synchronized void increment() { ++count; }
			public int getCount() { return count; }
		}
		final Counter counter = new Counter();
		class CountingThread extends Thread {
			public void run() {
				for (int i=0; i<10000; ++i) {
					// 两线程同时征用时，会发生竞态条件（即代码行为取决于操作时序）
					counter.increment();
				}
			}
		}
		CountingThread t1 = new CountingThread();
		CountingThread t2 = new CountingThread();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(counter.getCount());
	}
}

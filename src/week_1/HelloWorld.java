package week_1;
public class HelloWorld {
	public static void main(String[] args) throws InterruptedException{
		// 创建并启动一个Thread实例
		Thread myThread = new Thread() {
			public void run() {
				System.out.println("Hello from new thread");
			}
		};
		myThread.start();
		// 通知调度器：当前线程想要让出对处理器的占用
		// 如果不调用Thread.yield()，由于创建新线程要花费一些时间，那main线程几乎肯定会先执行println()，当然也不保证一定如此
		Thread.yield();
		System.out.println("Hello from main thread");
		// main线程调用join()来等待myThread线程结束（即run()函数返回）
		myThread.join();
	}
}

package week_1;
public class HelloWorld {
	public static void main(String[] args) throws InterruptedException{
		// ����������һ��Threadʵ��
		Thread myThread = new Thread() {
			public void run() {
				System.out.println("Hello from new thread");
			}
		};
		myThread.start();
		// ֪ͨ����������ǰ�߳���Ҫ�ó��Դ�������ռ��
		// ���������Thread.yield()�����ڴ������߳�Ҫ����һЩʱ�䣬��main�̼߳����϶�����ִ��println()����ȻҲ����֤һ�����
		Thread.yield();
		System.out.println("Hello from main thread");
		// main�̵߳���join()���ȴ�myThread�߳̽�������run()�������أ�
		myThread.join();
	}
}

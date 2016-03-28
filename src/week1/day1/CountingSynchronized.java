package week1.day1;
public class CountingSynchronized {
	public static void main(String[] args) throws InterruptedException{
		class Counter {
			private int count = 0;
			// ��̬�����Ľ�������ǶԷ��ʶ������ͬ������
			// һ�ַ�����ʹ��Java����ԭ������������ͬ����increment()�ĵ���
			public synchronized void increment() { ++count; }
			public int getCount() { return count; }
		}
		final Counter counter = new Counter();
		class CountingThread extends Thread {
			public void run() {
				for (int i=0; i<10000; ++i) {
					// ���߳�ͬʱ����ʱ���ᷢ����̬��������������Ϊȡ���ڲ���ʱ��
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

package week1.day1;
public class Puzzle {
	static boolean answerReady = false;
	static int answer = 0;
	static Thread t1 = new Thread() {
		public void run() {
			answer = 42;
			answerReady = true;
		}
	};
	static Thread t2 = new Thread() {
		public void run() {
			if (answerReady)
				System.out.println("The meaning of life is: " + answer);
			else
				System.out.println("I don't know the answer!");
		}
	};
	public static void main(String[] args) throws InterruptedException{
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}

/*	
 * “The meaning of life is: 0”
 *	乱序执行的可能原因：
 *	1. 编译器的静态优化打乱代码的执行顺序
 *	2. JVM的动态优化
 *	3. 硬件可以用过乱序执行来优化其性能
 *
 */
package thread;

public class ThreadEx2 {
	public static void main(String[] args) {
		
		Thread t1 = new BigLetters();
		SmallLetters t2 = new SmallLetters();
		
//		Runnable r = new NumPrint();
//		Thread t3 = new Thread(r);
		Thread t3 = new Thread(new NumPrint());
		
		t1.start();
		t2.start();
		t3.start();
	}
}

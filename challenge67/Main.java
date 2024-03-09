// TODO die executor class uitzoeken, ik snap het niet helemaal

package challenge67;
import challenge67.util.AsyncRandomWords;
import challenge67.util.NewThread;


class Main{
	public static void main(String[] args){
	NewThread newThread = new NewThread();
	newThread.start();
	System.out.println("hello");
	NewThread anotherThread = new NewThread();
	anotherThread.start();
	System.out.println("hello again");
	}
}
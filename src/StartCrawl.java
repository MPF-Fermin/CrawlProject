import com.mpf.thread.GrabData;
import com.mpf.thread.GrabDataImpl;


public class StartCrawl {
	public static void main(String[] args) {
		GrabData gdt = new GrabDataImpl();
		gdt.grabData();
	}
}

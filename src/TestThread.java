import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


public class TestThread extends Thread{
	public void run(){
		for(int i = 0; i < 10; i++){
			System.out.println(i);
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
		TestThread tt = new TestThread();
		tt.start();
		System.out.println("look at the running sequence!");
		long start = System.currentTimeMillis();
		while(true){
			System.out.println("Thread tt's status: "+ tt.getState());
			long end = System.currentTimeMillis();
			System.out.println("end - start = " + (end -start));
			if((end - start) > 15000)
				try {
					tt.stop();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if(tt.isAlive()){
				System.out.println("Thread tt is still running");
			}
			else{
				System.out.println("Thread tt has been interupted or stopped!");
				System.out.println("Thread tt's status: "+ tt.getState());
				break;
			}
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

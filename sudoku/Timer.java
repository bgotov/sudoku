package sudoku;

public class Timer implements Runnable {
	private long initTime = System.currentTimeMillis();
	private long currTime;

	@Override
	public void run() {
		while (true) {
			currTime = System.currentTimeMillis() - initTime;
			
			Verification.timer.setText(currTime/1000 + ":sec");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public long getCurrTime() {
		return currTime;
	}

}

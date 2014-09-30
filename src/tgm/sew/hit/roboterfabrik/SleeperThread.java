package tgm.sew.hit.roboterfabrik;

/**
 * Created by Patrick on 29.09.14.
 */
public class SleeperThread extends Thread {
	private boolean sleeping = false;
	public SleeperThread(long time){
		try {
			sleeping=true;
			this.sleep(time);
			sleeping=false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public boolean getStatus(){
		return  sleeping;
	}
}

package tgm.sew.hit.roboterfabrik;

/**
 * Created by Patrick on 29.09.14.
 */
class TimerWD implements Watchdog{
	private boolean keeprunning=true;
	private long length=0;
	private Thread sleeper = new Thread();

	public TimerWD(long length){
		this.length = length;
		sleeper.start();
	}

	public boolean tokeepRunning(){

		if(this.keeprunning == true) {
			return true;
		}else{return false;}

	}

	public void run(){
		try {
			sleeper.sleep(length);
			this.keeprunning=false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

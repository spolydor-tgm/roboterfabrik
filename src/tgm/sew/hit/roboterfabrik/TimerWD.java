package tgm.sew.hit.roboterfabrik;

/**
 * Created by Patrick on 29.09.14.
 */
class TimerWD implements Watchdog{
	boolean keeprunning=true;
	long length=0;
	Thread sleeper = new Thread();

	public TimerWD(long length){
		sleeper.start();
	}

	public boolean tokeepRunning(){

		if(keeprunning == true) {
			return true;
		}else{return false;}

	}

	public void run(){
		try {
			sleeper.sleep(length);
			keeprunning=false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

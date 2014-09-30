package tgm.sew.hit.roboterfabrik;

/**
 * Created by Patrick on 29.09.14.
 */
class TimerWD implements Watchdog{
	boolean keeprunning=true;
	long length=0;
	SleeperThread sleep;


	public TimerWD(long length){
		sleep = new SleeperThread(length);
	}

	public boolean tokeepRunning(){

		if(sleep.getStatus() == true) {
			return false;
		}else{return true;}

	}

	public void setTime(int time){

		keeprunning=false;

	}

}

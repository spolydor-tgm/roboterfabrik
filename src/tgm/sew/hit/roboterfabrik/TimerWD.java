package tgm.sew.hit.roboterfabrik;

/**
 * Created by Patrick on 29.09.14.
 */
class TimerWD extends Thread{
	private boolean keeprunning=true;
	private long length=0;
	private Thread sleeper;

	public TimerWD(long length){
		this.length = length;

		this.start();
	}

	public boolean tokeepRunning(){

		if(this.keeprunning == true) {
			return true;
		}else{return false;}

	}
	@Override
	public void run(){
		try {
			sleeper.sleep(length);
			this.keeprunning=false;
		} catch (InterruptedException e) {

		}

	}

}

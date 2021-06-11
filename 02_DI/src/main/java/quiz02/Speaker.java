package quiz02;

public class Speaker {

	private int volume; // 0 ~ 100
	
	public void volumeUp(int volume) {
		this.volume += volume;
		if(this.volume > 100) this.volume = 100;
	}
	public void volumeDown(int volume) {
		this.volume -= volume;
		if(this.volume < 0) this.volume = 0;
	}
	
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
}

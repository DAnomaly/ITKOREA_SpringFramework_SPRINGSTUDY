package quiz02;

import org.springframework.beans.factory.annotation.Autowired;

public class TV {

	private int ch; // 0 ~ 100
	private Speaker speaker;
	
	public void chUp() {
		ch++;
		if(ch > 100) ch = 0;
	}
	public void chDown() {
		ch--;
		if(ch < 0) ch = 100;
	}
	public void volUp(int volume) {
		speaker.volumeUp(volume);
	}
	public void volDown(int volume) {
		speaker.volumeDown(volume);
	}
	
	public int getCh() {
		return ch;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setCh(int ch) {
		this.ch = ch;
	}
	@Autowired
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	};

	public void info() {
		System.out.println("-----TV-----");
		System.out.println("체널: " + this.getCh());
		System.out.println("볼륨: " + speaker.getVolume());
	}

	
	
}

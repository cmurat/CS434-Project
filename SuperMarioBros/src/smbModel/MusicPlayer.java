package smbModel;

import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer {

	private String[] soundPaths = new String[] { "Assets/Sounds/smbTheme.MID",
			"Assets/Sounds/smbJump.wav", "Assets/Sounds/smbBreakblock.wav", "Assets/Sounds/smbMarioDie.wav" };

	private Sequencer musicSequencer;
	private Clip jumpClip;
	private Clip breakblockClip;
	private Clip marioDeathClip;

	private static MusicPlayer instance;

	private MusicPlayer() {
		instance = this;
		playMusic();
		initBreakblockClip();
		initJumpClip();
		initMarioDeathClip();
	}

	private void initBreakblockClip() {
		try {
			breakblockClip = AudioSystem.getClip();
			breakblockClip.open(AudioSystem.getAudioInputStream(new File(
					soundPaths[2])));
		} catch (Exception e) {
		}
	}

	private void initMarioDeathClip() {
		try {
			marioDeathClip = AudioSystem.getClip();
			marioDeathClip.open(AudioSystem.getAudioInputStream(new File(
					soundPaths[3])));
		} catch (Exception e) {
		}
	}

	public static MusicPlayer getInstance() {
		if (instance == null)
			instance = new MusicPlayer();
		return instance;
	}

	private void initJumpClip() {
		try {
			jumpClip = AudioSystem.getClip();
			jumpClip.open(AudioSystem.getAudioInputStream(new File(
					soundPaths[1])));
		} catch (Exception e) {
		}
	}
	
	private void playMusic() {
		play(soundPaths[0], Integer.MAX_VALUE);
	}

	private void play(String musicPath, int loopCount) {
		musicSequencer = null;
		try {
			Sequence sequence = MidiSystem.getSequence(new File(musicPath));
			musicSequencer = MidiSystem.getSequencer();
			musicSequencer.open();
			musicSequencer.setSequence(sequence);
			musicSequencer.setLoopCount(loopCount);
			musicSequencer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void playBreakblockSound() {
		breakblockClip.setMicrosecondPosition(0);
		breakblockClip.start();
	}

	public void playJumpSound() {
		jumpClip.setMicrosecondPosition(0);
		jumpClip.start();
	}

	public void playMarioDeathSound() {
		musicSequencer.stop();
		marioDeathClip.setMicrosecondPosition(0);
		marioDeathClip.start();
	}
}

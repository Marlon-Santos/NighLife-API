package com.nightlife.model;

public enum StatusMusic {

	ROCK ("Rock"),
	JAZZ ("Jazz"),
	BLUES ("Blues"),
	RAP ("Rap"),
	RB ("R&B"),
	FOLK("Folk"),
	POP ("Pop"),
	HIPHOP ("Hip-Hop");
	
	private String musicStyle;
	
	private StatusMusic(String musicStyle) {
		this.musicStyle = musicStyle;
	}

	public String getMusicStyle() {
		return musicStyle;
	}

	public void setMusicStyle(String musicStyle) {
		this.musicStyle = musicStyle;
	}
}

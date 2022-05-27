package realpage.catalogbackend.dto;

public class FilterShowDto {
	
	private String keyName; 
	private String language;
	private String genre;
	private String channel; 
	private String scheduleTime;
	
	public FilterShowDto(String keyName, String language, String genre, String channel, String scheduleTime) {
		super();
		this.keyName = keyName;
		this.language = language;
		this.genre = genre;
		this.channel = channel;
		this.scheduleTime = scheduleTime;
	}

	public String getKeyName() {
		return keyName;
	}

	public String getLanguage() {
		return language;
	}

	public String getGenre() {
		return genre;
	}

	public String getChannel() {
		return channel;
	}

	public String getScheduleTime() {
		return scheduleTime;
	}
	
	
	
	

}

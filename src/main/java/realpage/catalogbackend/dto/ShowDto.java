package realpage.catalogbackend.dto;

/**
 * 
 * @author Carlos Torres
 *
 */
public class ShowDto {

	private long id;
	
	private String name;
	
	private String language;
	
	private String genre;
	
	private String image;
	
	private String channel;
	
	private String scheduleTime;
	
	public ShowDto(long id, String name, String language, String genre, String image, String channel,
			String scheduleTime, String summary) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.genre = genre;
		this.image = image;
		this.channel = channel;
		this.scheduleTime = scheduleTime;
		this.summary = summary;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private String summary;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}	
	
}

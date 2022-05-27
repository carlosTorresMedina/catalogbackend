package realpage.catalogbackend.dto;

/**
 * 
 * @author Carlos Torres
 *
 */
public class EpisodeDto {
	
	private long id;
	
	private String name;
	
	private int order;
	
	private String releaseDate;
	
	private String duration;
	
	private String summary;

	private String image;
	
	public EpisodeDto(long id, String name, int order, String releaseDate, String duration, String summary, String image) {
		super();
		this.id = id;
		this.name = name;
		this.order = order;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.summary = summary;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

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

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	

}

package realpage.catalogbackend.dto;

/**
 * 
 * @author Carlos Torres
 *
 */
public class SeasonDto {
	
	private long id;
	
	private int number;
	
	private int cantEpisodes;
	
	private String releaseDate;
	
	private String endDate;
	
	public SeasonDto(long id, int number, int cantEpisodes, String releaseDate, String endDate) {
		super();
		this.id = id;
		this.number = number;
		this.cantEpisodes = cantEpisodes;
		this.releaseDate = releaseDate;
		this.endDate = endDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getCantEpisodes() {
		return cantEpisodes;
	}

	public void setCantEpisodes(int cantEpisodes) {
		this.cantEpisodes = cantEpisodes;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	
	
}

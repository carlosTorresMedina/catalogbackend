package realpage.catalogbackend.dto;

/**
 * 
 * @author Carlos Torres
 *
 */
public class CastDto {

	private long id;
	
	private String name;
	
	private String country;
	
	private String birthday;
	
	private String gender;
	
	private String image;
	
	private String character;

	public CastDto(long id, String name, String country, String birthday, String gender, String image,
			String character) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.birthday = birthday;
		this.gender = gender;
		this.image = image;
		this.character = character;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}
	
	
	
}

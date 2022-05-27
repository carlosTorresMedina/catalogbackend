package realpage.catalogbackend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import realpage.catalogbackend.dto.CastDto;
import realpage.catalogbackend.util.MapperUtils;

/**
 * Class used to map data related to 'Cast' object
 * @author Carlos Torres
 *
 */
public class CastMapper {

	private CastMapper() {}
	
	/**
	 * Creates cast list from JSON array
	 * @param json {@link JSONArray} used to extract the data and create the cast list
	 * @return cast list
	 */
	public static List<CastDto> createListCastFromJsonArray(JSONArray json) {
		List<CastDto> cast = new ArrayList<CastDto>();
		for (int i=0; i < json.length(); i++) {
		    JSONObject item = json.getJSONObject(i);
		    cast.add(createEpisodeFromJson(item.getJSONObject("person")));
		}
		return cast;
	}
	
	/**
	 * Creates an episode object from JSON object
	 * @param json {@link JSONObject} used to extract the data and create the episode object
	 * @return cast object
	 */
	public static CastDto createEpisodeFromJson(JSONObject json) {
	    long id = json.getLong("id");
	    String name = MapperUtils.getStringKey(json, "name");
	    String country = json.isNull("country") ? "" : json.getJSONObject("country").getString("name");
	    String birthday = MapperUtils.getStringKey(json, "birthday");
	    String gender = MapperUtils.getStringKey(json, "gender");
	    String image = json.isNull("image") ? "" : json.getJSONObject("image").getString("medium");
	    String character = json.isNull("character") ? "" : json.getJSONObject("character").getString("name");
	    return new CastDto(id, name, country, birthday, gender, image, character);
	}
}

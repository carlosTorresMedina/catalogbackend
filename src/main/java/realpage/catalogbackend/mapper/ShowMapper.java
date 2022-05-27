package realpage.catalogbackend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import realpage.catalogbackend.dto.ShowDto;
import realpage.catalogbackend.util.MapperUtils;

/**
 * Class used to map 'Show' object
 * @author Carlos Torres
 *
 */
public class ShowMapper {

	private ShowMapper() {}
	
	/**
	 * Creates a show list from JSON array and nested key
	 * @param json {@link JSONArray} used to extract data and create show list
	 * @param nestedKey used to validate if it is a nested key
	 * @return show list
	 */
	public static List<ShowDto> createListShowFromJsonArray(JSONArray json, boolean nestedKey) {
		List<ShowDto> shows = new ArrayList<ShowDto>();
		for (int i=0; i < json.length(); i++) {
		    JSONObject item = json.getJSONObject(i);
		    shows.add(nestedKey ? createShowFromJson(item) : createShowFromJson(item.getJSONObject("show")));
		}
		return shows;
	}
	
	/**
	 * Creates show object from JSON object
	 * @param json {@link JSONObject} used to extract data and create show object
	 * @return show object
	 */
	public static ShowDto createShowFromJson(JSONObject json) {
	    long id = json.getLong("id");
	    String name = MapperUtils.getStringKey(json, "name");
	    String summary = MapperUtils.getStringKey(json, "summary");
	    String language = MapperUtils.getStringKey(json, "language");
	    String image = json.isNull("image") ? "" : json.getJSONObject("image").getString("medium");
	    String genre = json.isNull("genres") ? "" : json.getJSONArray("genres").toString();
	    String channel = json.isNull("network") ? "" : json.getJSONObject("network").getString("name");
	    String schedule = json.isNull("schedule") ? "" : json.getJSONObject("schedule").getString("time");
	    return new ShowDto(id, name, language, genre, image, channel, schedule, summary);
	}
	
}

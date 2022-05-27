package realpage.catalogbackend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import realpage.catalogbackend.dto.EpisodeDto;
import realpage.catalogbackend.util.MapperUtils;

/**
 * Class used to map 'episode' object
 * @author Carlos Torres
 */
public class EpisodeMapper {

	private EpisodeMapper() {}
	
	/**
	 * Creates an episode list from JSON array
	 * @param json {@link JSONArray} used to extract data and create the episode list
	 * @return episode list
	 */
	public static List<EpisodeDto> createListEpisodesFromJsonArray(JSONArray json) {
		List<EpisodeDto> episodes = new ArrayList<EpisodeDto>();
		for (int i=0; i < json.length(); i++) {
		    JSONObject item = json.getJSONObject(i);
		    episodes.add(createEpisodeFromJson(item));
		}
		return episodes;
	}
	
	/**
	 * Creates episode object from JSON object
	 * @param json {@link JSONObject} used to extract data and create the episode object
	 * @return episode list
	 */
	public static EpisodeDto createEpisodeFromJson(JSONObject json) {
	    long id = json.getLong("id");
	    String name = MapperUtils.getStringKey(json, "name");
	    int order = MapperUtils.getIntKey(json, "number");
	    String releaseDate = MapperUtils.getStringKey(json, "airdate");
	    String duration = MapperUtils.getStringKey(json, "airtime");
	    String summary = MapperUtils.getStringKey(json, "summary");
	    String image = json.isNull("image") ? "" : json.getJSONObject("image").getString("medium");
	    return new EpisodeDto(id, name, order, releaseDate, duration, summary, image);
	}
	
}

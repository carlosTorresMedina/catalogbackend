package realpage.catalogbackend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import realpage.catalogbackend.dto.SeasonDto;
import realpage.catalogbackend.util.MapperUtils;

/**
 * Class used to map 'season' object
 * @author Carlos Torres
 *
 */
public class SeasonMapper {

	private SeasonMapper() {}
	
	/**
	 * Creates Season list from JSON array
	 * @param json {@link JSONArray} used to extract data and create the season list
	 * @return season's list
	 */
	public static List<SeasonDto> createListSeasonFromJsonArray(JSONArray json) {
		List<SeasonDto> seasons = new ArrayList<SeasonDto>();
		for (int i=0; i < json.length(); i++) {
		    JSONObject item = json.getJSONObject(i);
		    seasons.add(createSeasonFromJson(item));
		}
		return seasons;
	}

	/**
	 * Creates season object from JSON object
	 * @param json {@link JSONObject} used to extract data and create the season object
	 * @return season object
	 */
	public static SeasonDto createSeasonFromJson(JSONObject json) {
	    long id = json.getLong("id");
	    int number = MapperUtils.getIntKey(json, "number");
	    int cantEpisodes = MapperUtils.getIntKey(json, "episodeOrder");
	    String releaseDate = MapperUtils.getStringKey(json, "premiereDate");
	    String endDate = MapperUtils.getStringKey(json, "endDate");
	    return new SeasonDto(id, number, cantEpisodes, releaseDate, endDate);
	}
	
	
}

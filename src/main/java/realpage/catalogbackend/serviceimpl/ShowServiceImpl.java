package realpage.catalogbackend.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import realpage.catalogbackend.dto.FilterShowDto;
import realpage.catalogbackend.dto.ShowDto;
import realpage.catalogbackend.mapper.ShowMapper;
import realpage.catalogbackend.service.IShowService;
import realpage.catalogbackend.tvmazeapi.TvMazeApiHandler;
import realpage.catalogbackend.util.EObjectResponseCode;
import realpage.catalogbackend.util.ObjectResponse;

/**
 * Service used to manage all the features related to 'show'
 * 
 * @author Carlos Torres
 *
 */
@Service
public class ShowServiceImpl implements IShowService {

	private final TvMazeApiHandler tvMazeApiHandler;
	private static final Logger logger = LogManager.getLogger(ShowServiceImpl.class);

	@Autowired
	public ShowServiceImpl(TvMazeApiHandler tvMazeApiHandler) {
		this.tvMazeApiHandler = tvMazeApiHandler;
	}

	@Override
	public ObjectResponse<List<ShowDto>> getAllShow() {
		try {
			String jsonResponse = tvMazeApiHandler.executeGetRequest("shows");
			JSONArray json = new JSONArray(jsonResponse);
			List<ShowDto> showList = ShowMapper.createListShowFromJsonArray(json, true);
			return new ObjectResponse<>(EObjectResponseCode.CORRECT,"status ok",showList);
		} catch (Exception e) {
			String message = ShowServiceImpl.class.getName() + "-getAllShow ";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		
		}
	}

	@Override
	public ObjectResponse<ShowDto> getShowById(long id) {
		try {
			String jsonResponse = tvMazeApiHandler.executeGetRequest("shows/" + id);
			JSONObject json = new JSONObject(jsonResponse);
			ShowDto showDto = ShowMapper.createShowFromJson(json); 
			return new ObjectResponse<>(EObjectResponseCode.CORRECT,"status ok",showDto);
		} catch (Exception e) {
			String message = ShowServiceImpl.class.getName() + "-getShowById";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		
		}
	}

	@Override
	public ObjectResponse<List<ShowDto>> filterShow(FilterShowDto filterShowDto) {
		try {
			String jsonResponse = filterShowDto.getKeyName().isEmpty() ? tvMazeApiHandler.executeGetRequest("shows")
					: tvMazeApiHandler.executeGetRequest("search/shows?q=" + filterShowDto.getKeyName());
			JSONArray json = new JSONArray(jsonResponse);
			List<ShowDto> shows = ShowMapper.createListShowFromJsonArray(json, filterShowDto.getKeyName().isEmpty());
			return new ObjectResponse<>(EObjectResponseCode.CORRECT,"status ok",applyFilterShow(shows, filterShowDto));
		} catch (Exception e) {
			String message = ShowServiceImpl.class.getName() + "-filterShow";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		
		}
	}

	/**
	 * Gets the show list filtered by the filter used
	 * 
	 * @param shows         {@link List<ShowDto} used to make the filter
	 * @param filterShowDto {@link FilterShowDto} used to filter the data
	 * @return show list
	 */
	private List<ShowDto> applyFilterShow(List<ShowDto> shows, FilterShowDto filterShowDto) {
		return shows.stream()
				.filter(show -> filterShowDto.getLanguage().trim().isEmpty()
						|| show.getLanguage().equalsIgnoreCase(filterShowDto.getLanguage().trim()))
				.filter(show -> filterShowDto.getGenre().trim().isEmpty()
						|| show.getGenre().contains(filterShowDto.getGenre().trim()))
				.filter(show -> filterShowDto.getChannel().trim().isEmpty()
						|| show.getChannel().equalsIgnoreCase(filterShowDto.getChannel().trim()))
				.filter(show -> filterShowDto.getScheduleTime().trim().isEmpty()
						|| show.getScheduleTime().equalsIgnoreCase(filterShowDto.getScheduleTime().trim()))
				.collect(Collectors.toList());

	}


}

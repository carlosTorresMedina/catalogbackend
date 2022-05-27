package realpage.catalogbackend.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import realpage.catalogbackend.dto.SeasonDto;
import realpage.catalogbackend.mapper.SeasonMapper;
import realpage.catalogbackend.service.ISeasonService;
import realpage.catalogbackend.tvmazeapi.TvMazeApiHandler;
import realpage.catalogbackend.util.EObjectResponseCode;
import realpage.catalogbackend.util.ObjectResponse;

/**
 * Service used to manage all the features related to 'Season'
 * 
 * @author Carlos Torres
 *
 */
@Service
public class SeasonServiceImpl implements ISeasonService {

	private final TvMazeApiHandler tvMazeApiHandler;
	private static final Logger logger = LogManager.getLogger(SeasonServiceImpl.class);

	@Autowired
	public SeasonServiceImpl(TvMazeApiHandler tvMazeApiHandler) {
		this.tvMazeApiHandler = tvMazeApiHandler;
	}

	@Override
	public ObjectResponse<List<SeasonDto>> getSeasonsByShow(long idShow)  {
		try {
			String jsonResponse = tvMazeApiHandler.executeGetRequest("shows/" + idShow + "/seasons");
			JSONArray json = new JSONArray(jsonResponse);
			List<SeasonDto> seasonList = SeasonMapper.createListSeasonFromJsonArray(json);
			return new ObjectResponse<>(EObjectResponseCode.CORRECT,"status ok",seasonList);
		} catch (Exception e) {
			String message = SeasonServiceImpl.class.getName()+"-getSeasonByShow ";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		
		}
	}

}

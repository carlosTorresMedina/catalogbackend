package realpage.catalogbackend.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import realpage.catalogbackend.dto.EpisodeDto;
import realpage.catalogbackend.mapper.EpisodeMapper;
import realpage.catalogbackend.service.IEpisodeService;
import realpage.catalogbackend.tvmazeapi.TvMazeApiHandler;
import realpage.catalogbackend.util.EObjectResponseCode;
import realpage.catalogbackend.util.ObjectResponse;

/**
 * Service used to manage all the features related to 'Episode'
 * @author Carlos Torres
 *
 */
@Service
public class EpisodeServiceImpl implements IEpisodeService {

	private final TvMazeApiHandler tvMazeApiHandler;
	private static final Logger logger = LogManager.getLogger(EpisodeServiceImpl.class);
	
	@Autowired
	public EpisodeServiceImpl(TvMazeApiHandler tvMazeApiHandler) {
		this.tvMazeApiHandler = tvMazeApiHandler;
	}
	
	@Override
	public ObjectResponse<List<EpisodeDto>> getEpisodesBySeason(long idSeason) {
		try {
			String jsonResponse = tvMazeApiHandler.executeGetRequest("seasons/" + idSeason + "/episodes");
			JSONArray json = new JSONArray(jsonResponse);
			List<EpisodeDto> episodeList = EpisodeMapper.createListEpisodesFromJsonArray(json);
			return new ObjectResponse<>(EObjectResponseCode.CORRECT, "status ok",episodeList);
		} catch (Exception e) {
			String message = EpisodeServiceImpl.class.getName()+"-getEpisodesBySeason ";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		}
	}
	
	@Override
	public ObjectResponse<List<EpisodeDto>> getEpisodesByDate(long idShow, String date) {
		try {
			String jsonResponse = tvMazeApiHandler.executeGetRequest("shows/" + idShow + "/episodesbydate?date=" + date);
			JSONArray json = new JSONArray(jsonResponse);
			List<EpisodeDto> episodeList = EpisodeMapper.createListEpisodesFromJsonArray(json);
			return new ObjectResponse<>(EObjectResponseCode.CORRECT, "status ok", episodeList);
		} catch (Exception e) {
			String message = EpisodeServiceImpl.class.getName()+"-getEpisodesByDate ";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		
		}
	}
	
}

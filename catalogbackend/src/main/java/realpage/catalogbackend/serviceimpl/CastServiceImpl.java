package realpage.catalogbackend.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import realpage.catalogbackend.dto.CastDto;
import realpage.catalogbackend.mapper.CastMapper;
import realpage.catalogbackend.service.ICastService;
import realpage.catalogbackend.tvmazeapi.TvMazeApiHandler;
import realpage.catalogbackend.util.EObjectResponseCode;
import realpage.catalogbackend.util.ObjectResponse;

/**
 * Service used to manage all the features related to 'Cast'
 * @author Carlos Torres
 *
 */
@Service
public class CastServiceImpl implements ICastService {

	private static final Logger logger = LogManager.getLogger(CastServiceImpl.class);
	private final TvMazeApiHandler tvMazeApiHandler;
	
	@Autowired
	public CastServiceImpl(TvMazeApiHandler tvMazeApiHandler) {
		this.tvMazeApiHandler=tvMazeApiHandler;
	}
	
	@Override
	public ObjectResponse<List<CastDto>> getCastByShow(long idShow) {
		try {
			String jsonResponse = tvMazeApiHandler.executeGetRequest("shows/" + idShow + "/cast");
			JSONArray json = new JSONArray(jsonResponse);
			List<CastDto> castList = CastMapper.createListCastFromJsonArray(json);
			return new ObjectResponse<>(EObjectResponseCode.CORRECT,"status ok", castList);
		} catch (Exception e) {
			String message = CastServiceImpl.class.getName()+"-getCastByShow ";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		}
	}
	
}

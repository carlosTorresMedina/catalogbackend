package realpage.catalogbackend.service;

import java.util.List;

import realpage.catalogbackend.dto.SeasonDto;
import realpage.catalogbackend.util.ObjectResponse;

/**
 * Interface to abstract 'season' features
 * @author Carlos Torres
 *
 */
public interface ISeasonService {

	/**
	 * Gets season list filter by show
	 * @param idShow used to make the searching
	 * @return object response with season list data
	 */
	public ObjectResponse<List<SeasonDto>> getSeasonsByShow(long idShow);
	
}

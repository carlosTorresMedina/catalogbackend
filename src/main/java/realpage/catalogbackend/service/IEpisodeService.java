package realpage.catalogbackend.service;

import java.util.List;

import realpage.catalogbackend.dto.EpisodeDto;
import realpage.catalogbackend.util.ObjectResponse;

/**
 * Interface to abstract 'episode' features
 * @author CARLOS TORRES
 *
 */
public interface IEpisodeService {

	/**
	 * Gets the episode list filter by season
	 * @param idSeason used to make the searching
	 * @return object response with episode list data
	 */
	public ObjectResponse<List<EpisodeDto>> getEpisodesBySeason(long idSeason) ;
	
	/**
	 * Gets the episode list filter by date
	 * @param idShow used to make the searching
	 * @param date {@link String} used to make the searching
	 * @return object response with episode list data
	 */
	public ObjectResponse<List<EpisodeDto>> getEpisodesByDate(long idShow, String date); 
	
}

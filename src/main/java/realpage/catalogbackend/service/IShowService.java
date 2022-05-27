package realpage.catalogbackend.service;

import java.util.List;

import realpage.catalogbackend.dto.FilterShowDto;
import realpage.catalogbackend.dto.ShowDto;
import realpage.catalogbackend.util.ObjectResponse;

/**
 * Interface to abstract 'show' features
 * @author Carlos Torres
 *
 */
public interface IShowService {

	/**
	 * Gets the show list
	 * @return object response with show list data
	 */
	public ObjectResponse<List<ShowDto>> getAllShow();
	
	/**
	 * Gets the show list filter by id
	 * @param id used to make the filter
	 * @return object response with show list data
	 */
	public ObjectResponse<ShowDto> getShowById(long id);
	
	/**
	 * Gets the show list filter by an specific filter 
	 * @param filterShowDto {@link} used to filter the data
	 * @return object response with show list data
	 */
	public ObjectResponse<List<ShowDto>> filterShow(FilterShowDto filterShowDto);
	
}

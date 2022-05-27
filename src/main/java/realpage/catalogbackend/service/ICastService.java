package realpage.catalogbackend.service;

import java.util.List;

import realpage.catalogbackend.dto.CastDto;
import realpage.catalogbackend.util.ObjectResponse;

/**
 * Interface to abstract 'cast' features
 * @author CARLOS TORRES
 *
 */
public interface ICastService {
	
	/**
	 * Gets a cast list filter By show
	 * @param idShow used to make the searching
	 * @return object response with list cast data
	 */
	public ObjectResponse<List<CastDto>> getCastByShow(long idShow);

}

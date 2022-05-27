package realpage.catalogbackend.restcontroller;

import java.util.List;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import realpage.catalogbackend.dto.EpisodeDto;
import realpage.catalogbackend.service.IEpisodeService;
import realpage.catalogbackend.util.EObjectResponseCode;
import realpage.catalogbackend.util.ObjectResponse;
import realpage.catalogbackend.util.FunctionUtils;

/**
 * Controller used to manage 'episode' rest api
 * @author Carlos Torres
 *
 */
@RequestMapping("api/v1/episode")
@RestController
public class EpisodeController {

	private final IEpisodeService episodeService;
	
	@Autowired
	public EpisodeController(IEpisodeService episodeService) {
		this.episodeService = episodeService;
	}
	
	/**
	 * Gets the episode list filter by season
	 * @param idSeason to filter
	 * @return response entity object
	 */
	@GetMapping(path = "season/{idSeason}")
	public ResponseEntity<?> getEpisodeBySeason(@PathVariable("idSeason") long idSeason) {
			ObjectResponse<List<EpisodeDto>> objectResponse = episodeService.getEpisodesBySeason(idSeason);
			BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
					.generarFunctionResponseEntity();
			return function.apply(objectResponse.getResponseCode(), objectResponse);
	}
	
	/**
	 * Gets the episode list filter by date
	 * @param idShow to filter
	 * @param date to filter
	 * @return response entity object
	 */
	@GetMapping(path = "filter/{idShow}/{date}")
	public ResponseEntity<?> getEpisodeBySeason(@PathVariable("idShow") long idShow, @PathVariable("date") String date) {
			ObjectResponse<List<EpisodeDto>> objectResponse = episodeService.getEpisodesByDate(idShow, date); 
			BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
					.generarFunctionResponseEntity();
			return function.apply(objectResponse.getResponseCode(), objectResponse);
	}
	
}

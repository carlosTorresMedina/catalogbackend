package realpage.catalogbackend.restcontroller;

import java.util.List;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import realpage.catalogbackend.dto.SeasonDto;
import realpage.catalogbackend.service.ISeasonService;
import realpage.catalogbackend.util.EObjectResponseCode;
import realpage.catalogbackend.util.ObjectResponse;
import realpage.catalogbackend.util.FunctionUtils;


/**
 * Controller used to manage 'season' rest api
 * @author Carlos Torres
 *
 */
@RequestMapping("api/v1/season")
@RestController
public class SeasonController {

	private final ISeasonService seasonService;
	
	@Autowired
	public SeasonController(ISeasonService seasonService) {
		this.seasonService = seasonService;
	}
	
	/**
	 * Gets season list filter by show
	 * @param idShow to filter
	 * @return response entity object
	 */
	@GetMapping(path = "show/{idShow}")
	public ResponseEntity<?> getSeasonsByShow(@PathVariable("idShow") long idShow) {
		ObjectResponse<List<SeasonDto>> objectResponse = seasonService.getSeasonsByShow(idShow);
		BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
				.generarFunctionResponseEntity();
		return function.apply(objectResponse.getResponseCode(), objectResponse);
	}
}

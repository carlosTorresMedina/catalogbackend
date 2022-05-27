package realpage.catalogbackend.restcontroller;

import java.util.List;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import realpage.catalogbackend.dto.FilterShowDto;
import realpage.catalogbackend.dto.ShowDto;
import realpage.catalogbackend.service.IShowService;
import realpage.catalogbackend.util.EObjectResponseCode;
import realpage.catalogbackend.util.ObjectResponse;
import realpage.catalogbackend.util.FunctionUtils;

/**
 * Controller used to manage 'show' rest api
 * @author Carlos Torres
 *
 */
@RequestMapping("api/v1/show")
@RestController
public class ShowsController {
	
	private final IShowService showService;
	
	@Autowired
	public ShowsController(IShowService showService) {
		this.showService = showService;
	}
	
	/**
	 * Gets the show list
	 * @return response entity object
	 */
	@GetMapping
	public ResponseEntity<?> getAll() {
		ObjectResponse<List<ShowDto>> objectResponse =  showService.getAllShow(); 
		BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
				.generarFunctionResponseEntity();
		return function.apply(objectResponse.getResponseCode(), objectResponse);
	}
	
	/**
	 * Gets the show list filter by id
	 * @param id to filter
	 * @return response entity object
	 */
	@GetMapping(path = "{id}")
	public ResponseEntity<?> getShowById(@PathVariable("id") long id) {
			ObjectResponse<ShowDto> objectResponse = showService.getShowById(id);
			BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
					.generarFunctionResponseEntity();
			return function.apply(objectResponse.getResponseCode(), objectResponse);
	}

	/**
	 * Gets the show list filter by an specific filter 
	 * @param keyname to filter
	 * @param language to filter
	 * @param genre to filter
	 * @param channel to filter
	 * @param scheduleTime to filter
	 * @return response entity object
	 */
	@GetMapping(path = "/filter")
	public ResponseEntity<?> getShowByFilters(@RequestParam(value = "keyname") String keyname, @RequestParam(value ="language") String language,
			@RequestParam(value = "genre") String genre, @RequestParam(value ="channel") String channel, @RequestParam(value = "scheduleTime") String scheduleTime) {
		FilterShowDto filterShowDto = new FilterShowDto(keyname, language, genre, channel, scheduleTime);
		ObjectResponse<List<ShowDto>> objectResponse = showService.filterShow(filterShowDto);
		BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
				.generarFunctionResponseEntity();
		return function.apply(objectResponse.getResponseCode(), objectResponse);
	}
	
}

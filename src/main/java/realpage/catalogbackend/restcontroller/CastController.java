package realpage.catalogbackend.restcontroller;

import java.util.List;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import realpage.catalogbackend.dto.CastDto;
import realpage.catalogbackend.service.ICastService;
import realpage.catalogbackend.util.EObjectResponseCode;
import realpage.catalogbackend.util.ObjectResponse;
import realpage.catalogbackend.util.FunctionUtils;

/**
 * Controller used to manage 'cast' rest api
 * @author Carlos Torres
 *
 */
@RequestMapping("api/v1/cast")
@RestController
public class CastController {

	private final ICastService castService;

	@Autowired
	public CastController(ICastService castService) {
		this.castService = castService;
	}

	/**
	 * Gets a cast list filter By show
	 * @param idShow to filter
	 * @return response entity object
	 */
	@GetMapping(path = "show/{idShow}")
	public ResponseEntity<?> getCastByShow(@PathVariable("idShow") long idShow) {
		ObjectResponse<List<CastDto>> objectResponse = castService.getCastByShow(idShow);
		BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
				.generarFunctionResponseEntity();
		return function.apply(objectResponse.getResponseCode(), objectResponse);
	}

}

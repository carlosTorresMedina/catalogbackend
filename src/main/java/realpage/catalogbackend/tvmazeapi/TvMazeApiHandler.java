package realpage.catalogbackend.tvmazeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Class used to connect to the web service rest tv.maze
 * 
 * @author Carlos Torres
 */
@Component
public class TvMazeApiHandler {
	
	private final String urlTvMazeService;
	
	@Autowired
	public TvMazeApiHandler(@Qualifier("urlTvMazeService") String urlTvMazeService) {
		this.urlTvMazeService = urlTvMazeService;
	}
	
	/**
	 * execute an specific search in the web service
	 * @param resource {@link String} is the data used to create the search
	 * @return JSON information
	 */
	public String executeGetRequest(String resource) {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = urlTvMazeService + resource ;
		ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
		return response.getBody();
	}

}

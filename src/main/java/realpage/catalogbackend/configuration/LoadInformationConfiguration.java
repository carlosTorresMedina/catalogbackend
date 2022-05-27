package realpage.catalogbackend.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


/**
 * Class used to charge special information from application properties file
 * 
 * @author Carlos Torres
 *
 */
@Configuration
@PropertySource("classpath:application.properties")
public class LoadInformationConfiguration {

	private final Environment env;

	@Autowired
	public LoadInformationConfiguration(Environment env) {
		this.env = env;
	}

	@Bean(name = "urlTvMazeService")
	public String urlTvMazeService() {
		String result = env.getProperty("tvmazeservice.url");
		return result;
	}

}

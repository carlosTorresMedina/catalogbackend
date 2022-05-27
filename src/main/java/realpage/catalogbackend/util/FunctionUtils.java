package realpage.catalogbackend.util;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Class used to manage utilities related to Rest 
 * @author Carlos Torres
 */
public class FunctionUtils {

	private FunctionUtils() {}
	
	/**
	 * Create a 'BiFunction' with the necessary logic to generate a response entity
	 * 
	 * @return {@link BiFunction} object used to generate a response entity
	 */
	public static BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> generarFunctionResponseEntity() {
        BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = (cod, resp) -> {
            ResponseEntity<?> result = null;
            switch (cod) {
                case CORRECT:
                case WARNING:
                    result = new ResponseEntity<>(resp, HttpStatus.OK);
                    break;
                case ERROR:
                    result = new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
                    break;
                 default:
                	  result = new ResponseEntity<>(resp, HttpStatus.SERVICE_UNAVAILABLE);
            }
            return result;
        };
        return function;
    }
	
	/**
	 * Function to encrypt the data
	 * @return function to the logic to encrypt
	 */
	 public static Function<String, String> generateHashWithApacheCommons() {
	        Function<String, String> function = (value) ->  DigestUtils.sha256Hex(value);
	       
	        return function;
	    }
	 
	 
}

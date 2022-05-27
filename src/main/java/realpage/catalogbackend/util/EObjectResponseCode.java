package realpage.catalogbackend.util;

/**
 * Enum used to represent the type of errors that the {@link ObjectResponse} can get
 * @author Carlos Torres
 *
 */
public enum EObjectResponseCode {

	/**
	 * CORRECT should be used when all the action was successful.
	 */
	CORRECT,
	/**
	 * WARNING should be used when exists an issue related with the action execution, but it is not an error.
	 */
	WARNING,
	/**
	 * ERROR should be used when exists an error during the action execution.
	 */
	ERROR
	
}

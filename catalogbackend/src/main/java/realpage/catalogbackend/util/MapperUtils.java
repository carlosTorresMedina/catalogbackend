package realpage.catalogbackend.util;

import org.json.JSONObject;

public class MapperUtils {

	public static String getStringKey(JSONObject json, String key) {
		String value = json.isNull(key) ? "" : json.getString(key);
		return value;
	}
	
	public static int getIntKey(JSONObject json, String key) {
		int value = json.isNull(key) ? 0 : json.getInt(key);
		return value;
	}
	
}

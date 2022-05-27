/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realpage.catalogbackend.util;


/**
 * Generic object used to create a response to send to controllers
 * @author carlos.torres
 */
public class ObjectResponse<T> {

    private final EObjectResponseCode responseCode;
    private final String responseDescription;
    private final T data;
    
	public ObjectResponse(EObjectResponseCode responseCode, String responseDescription, T data) {
		super();
		this.responseCode = responseCode;
		this.responseDescription = responseDescription;
		this.data = data;
	}
	public EObjectResponseCode getResponseCode() {
		return responseCode;
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	public T getData() {
		return data;
	}

}

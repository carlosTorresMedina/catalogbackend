/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realpage.catalogbackend.service;

import realpage.catalogbackend.dto.AuthenticationDto;
import realpage.catalogbackend.dto.AuthenticationResponseDto;
import realpage.catalogbackend.util.ObjectResponse;

/**
 *
 * @author carlos.torres
 */

public interface IAuthenticationService {

	public ObjectResponse<AuthenticationResponseDto> validateAuthorization(AuthenticationDto auth);

}

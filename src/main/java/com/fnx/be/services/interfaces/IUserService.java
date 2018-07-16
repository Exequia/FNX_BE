package com.fnx.be.services.interfaces;

import java.util.List;

import com.fnx.be.models.User;
import com.fnx.be.util.RestResponse;

public interface IUserService {

//	/***
//	 * Realiza una búsqueda en BBDD según el ID recibido y retora una lista de
//	 * usuarios que coincidan
//	 * 
//	 * @param id
//	 * @return List of User
//	 * @author areal
//	 */
//	RestResponse getUserById(Integer id);

	/**
	 * Recoge un listado de usuarios con el mail. Valida que solo haya uno y que la
	 * pass sea correcta
	 * 
	 * @param email
	 * @param pass
	 * @return Data: User si los datos son correctos.
	 * @author areal
	 */
	List<User> login(String email, String pass);

}

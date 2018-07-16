package com.fnx.be.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnx.be.daos.UserRepository;
import com.fnx.be.models.User;
import com.fnx.be.services.interfaces.IUserService;

@Service
public class UserServiceImp implements IUserService {
	
	final static Logger logger = Logger.getLogger(UserServiceImp.class);

	@Autowired
	protected UserRepository userRepository;

	// @Override
	// public RestResponse getUserById(Integer id) {
	// List<User> lstUsers = this.userRepository.findById(id);
	// RestResponse resp = new RestResponse();
	//
	// if (lstUsers.size() == 0) {
	// resp.setStatus(0);
	// resp.setMsg("No se han encontrado registros");
	// resp.setData(lstUsers);
	// } else if (lstUsers.size() > 1) {
	// resp.setStatus(0);
	// resp.setMsg("Se han encontrado más de un registro.");
	// resp.setData(lstUsers);
	// } else {
	// resp.setStatus(1);
	// resp.setMsg("OK");
	// resp.setData(lstUsers);
	// }
	//
	// return resp;
	// }
	

	@Override
	public List<User> login(String email, String pass) {
		
		List<User> lstUsers = null;
		
		try {
			
			lstUsers = this.userRepository.findByEmail(email);
			
		} catch (Exception e) {
			logger.error(e);
		}
		
		return lstUsers;
	}

//	@Override
//	public List<User> login(String email, String pass) {
//		return this.userRepository.findByEmail(email);
//		List<User> lstUsers = this.userRepository.findByEmail(email);
//		RestResponse resp = new RestResponse();
//
//		if (lstUsers.size() == 0) {
//			
//			resp.setStatus(0);
//			resp.setMsg("No se han encontrado registros");
//			
//		} else if (lstUsers.size() > 1) {
//			
//			resp.setStatus(0);
//			resp.setMsg("Se han encontrado más de un registro.");
//			
//		} else {
//			
//			User u = lstUsers.get(0);
//			if (u.getPass().equals(pass)) {
//				
//				resp.setStatus(1);
//				resp.setMsg("OK");
//				resp.setData(u);
//
//			} else {
//
//				resp.setStatus(0);
//				resp.setMsg("La constraseña indicada no es válida");
//				
//			}
//		}
//
//		return resp;
//	}

}

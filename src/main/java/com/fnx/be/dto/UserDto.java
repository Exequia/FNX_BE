package com.fnx.be.dto;

import java.util.Date;

public class UserDto {
	
//    @Autowired
//    private ModelMapper modelMapper;
	
	private int id;

	private String email;

	private Date inactive;

	private Date init;

	private String name;

	private String surname1;

	private String surname2;

//	private Role role;
	private RoleDto role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getInactive() {
		return inactive;
	}

	public void setInactive(Date inactive) {
		this.inactive = inactive;
	}

	public Date getInit() {
		return init;
	}

	public void setInit(Date init) {
		this.init = init;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname1() {
		return surname1;
	}

	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	public String getSurname2() {
		return surname2;
	}

	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

//	public RoleDto getRole() {
//		return convertToDto(role);
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
//	
//	private RoleDto convertToDto(Role role) {
//		RoleDto roleDto = modelMapper.map(role, RoleDto.class);
//	    return roleDto;
//	}

}

package com.auth.demo.constants;

public enum RoleConstants {

	ADMIN(1), USER(2);

	private int roleId;

	RoleConstants(int roleId) {
		// TODO Auto-generated constructor stub
		this.roleId = roleId;
	}

	public int getRoleId() {
		return roleId;
	}

}

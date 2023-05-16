package com.mhwc.jobPlatform.dao;


import com.mhwc.jobPlatform.model.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}

package com.encora.service;

import com.encora.model.UserDTO;

public interface RegisterService {

	public UserDTO saveOrUpdateUser(UserDTO userDTO);
}

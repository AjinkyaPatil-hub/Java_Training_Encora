package com.encora.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.encora.entity.UserEntity;
import com.encora.model.UserDTO;
import com.encora.repo.UserRepository;
import com.encora.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDTO saveOrUpdateUser(UserDTO userDTO) {
		//TODO ROLE implementation is remaining..
		userDTO.setRole("ADMIN");
		userDTO.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
		 UserEntity userEntity = mapper.map(userDTO, UserEntity.class);
		 UserEntity save = userRepository.save(userEntity);
		return mapper.map(save, UserDTO.class);	
	}

	
}

package com.encora.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponse {

	private String token;
	private String username;
}

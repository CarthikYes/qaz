package com.masai;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {

	private LocalDateTime dateTime;
	private String message;
	private String description;
	
}

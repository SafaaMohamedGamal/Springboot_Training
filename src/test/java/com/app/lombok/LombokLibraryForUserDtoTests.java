package com.app.lombok;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.shared.dto.UserDto;

class LombokLibraryForUserDtoTests {

	  private UserDto userDto;
	  @BeforeEach
	  public void setUp() throws Exception {
		  userDto = new UserDto();
	  }

	  @AfterEach
	  public void tearDown() throws Exception {
		  userDto = null;
	  }

	  @Test
	  public void testFieldLevelGetterSetter() {
		  userDto.setFirstName("Safaa");
		  assertEquals("Safaa", userDto.getFirstName());
	  }

}

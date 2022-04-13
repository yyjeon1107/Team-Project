package com.test.join;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


//유효성 검증 클래스

@Getter
@Setter
public class MemberForm {

	@Size(min=3, max=25)
	@NotEmpty(message = "사용자 ID는 필수항목입니다")
	 private String user_id;
	
	@NotEmpty(message = "비밀번호는 필수항목입니다")
	 private String password1;
	
	@NotEmpty(message = "비밀번호 확인은 필수항목입니다")
	 private String password2;
	
	@NotEmpty(message = "이름은 필수항목입니다")
	 private String name;
	 
	@Email
	 private String email;
	 
	 private String address;
	
	
}

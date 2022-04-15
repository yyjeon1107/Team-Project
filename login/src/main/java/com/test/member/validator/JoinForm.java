package com.test.member.validator;

import com.test.member.entity.Member;

import lombok.Data;

@Data
public class JoinForm {//join.html로 입력 받은 값을 담을 객체 
      private  String userId;
      private  String password;
      
      //테스트 검증용 메소드 << 웹페이지에서 검증된 값들 >>  입력된 데이터를 사용하는 객체를 멤버 테이블로 전달        
      public Member convertToMember() {    	  
    	    Member member  = new Member();
    	    member.setUserId(userId);
    	    member.setPassword(password);
    	    return member;    	    
      }
      
}

package com.test.join;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    private MemberDTO of(Member member) {
    	return this.modelMapper.map(member, MemberDTO.class);
    }
    
    public MemberDTO create(String user_id, String password, String name, String email, String address) {
        Member mem = new Member();
        mem.setUser_id(user_id);
        mem.setPassword(passwordEncoder.encode(password));
        mem.setName(name);
        mem.setEmail(email);
        mem.setAddress(address);
        this.memberRepository.save(mem);
        return of(mem);
    }
}

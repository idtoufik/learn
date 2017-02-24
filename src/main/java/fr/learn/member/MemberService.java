package fr.learn.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.learn.dao.Member;

@Service
public class MemberService {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	public void register(Member member)
	{
		member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
		memberRepository.save(member);
	}
	
	public Member findByPseudo(String pseudo)
	{
		return memberRepository.findByPseudo(pseudo);
	}
	
	
	 public List<Member> findAll()
	 {
		 List<Member> members = new ArrayList<>();
		 memberRepository.findAll().forEach(members::add);
		 return members;
	 }
	 
	 public void delete(long id)
	 {
		 memberRepository.delete(id);
	 }
	 
	 public Member getMember(long memberId)
	 {
		 return memberRepository.findOne(memberId);
	 }
	 
	 public void updateMember(Member member)
	 {
		 memberRepository.save(member);
	 }

	public Member findOne(long idMember) {
		return memberRepository.findOne(idMember);
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}

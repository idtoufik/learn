package fr.learn.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.learn.dao.Member;
@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/resources/members", method = RequestMethod.POST)
	public void registerMember(@RequestBody Member member)
	{
		System.out.println(member.getFirstName());
		memberService.register(member);
	}

	@RequestMapping(value = "/resources/members", method = RequestMethod.GET)
	public List<Member> getAllMembers()
	{
		return memberService.findAll();
	}
	
	@RequestMapping(value = "/resources/members/{idMember}", method = RequestMethod.DELETE)
	public void deleteMember(@PathVariable("idMember") long idMember)
	{
		memberService.delete(idMember);
	}
	
	
	@RequestMapping(value = "/resources/members/{idMember}", method = RequestMethod.GET)
	public Member getMember(@PathVariable("idMember") long idMember)
	{
		return memberService.getMember(idMember);
	}
	
	@RequestMapping(value = "/resources/members/{idMember}", method = RequestMethod.PUT)
	public void updateMember(@PathVariable("idMember") long idMember, @RequestBody Member member)
	{
		member.setId(idMember);
		member.setPassword(memberService.findOne(idMember).getPassword());
		memberService.updateMember(member);
	}
}

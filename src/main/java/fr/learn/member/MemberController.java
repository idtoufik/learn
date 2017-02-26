package fr.learn.member;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
		member.setId(null);
		member.setDateOfRegistration(new Date());
		memberService.register(member);
	}

	@RequestMapping(value = "/resources/members", method = RequestMethod.GET)
	public List<Member> getAllMembers()
	{
		
		List<Member> members = memberService.findAll();
		return members;
	}
	
	
	
	@RequestMapping(value = "/resources/members/{idMember}", method = RequestMethod.DELETE)
	public void deleteMember(@PathVariable("idMember") long idMember)
	{
		//TODO only the superUser can drop users
		memberService.delete(idMember);
	}
	
	@RequestMapping(value = "/resources/members/{idMember}", method = RequestMethod.GET)
	public Member getMember(@PathVariable("idMember") long idMember)
	{
		Member member = memberService.getMember(idMember);
		return member;
	}
	
	
	
	@RequestMapping(value = "/resources/members/{idMember}", method = RequestMethod.PUT)
	public void updateMember(@PathVariable("idMember") Long idMember, @RequestBody Member member)
	{
		//TODO mettre a jour user detailsService apres la mise a jour du model 
		/*
		 * 
		 * Authentication auth = SecurityContextHolder.getContext().setAuthentication();
		        if(auth.getPrincipal() != null)
		        {
		        	
		        	UserDetails details = (UserDetails)auth.getPrincipal();
		        	System.out.println(details.getUsername());
		        	details.setUsername(details.getUsername() +"1");
		        	
		        }
		 */
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Member loggedIn = memberService.getMemberFromAuthentification(auth);
		if(loggedIn != null && loggedIn.getId().equals(idMember))
		{
			member.setId(idMember);
			member.setPassword(memberService.findOne(idMember).getPassword());
			memberService.updateMember(member);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

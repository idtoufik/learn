package fr.learn.member;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.learn.dao.Member;

@Service
public class MemberDetailsService implements UserDetailsService{
	@Autowired
	private MemberService memberService;

	@Override
	public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
		Member member = memberService.findByPseudo(pseudo);
		
		if(member == null)
		{
			throw new UsernameNotFoundException("username not found");
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		/*for(Role role : member.getRoles())
		{
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}*/
		//System.out.println("toufik: " + member.getRoles());
		
		return new org.springframework.security.core.userdetails.User
				(member.getPseudo(), member.getPassword(), grantedAuthorities);
		
	}

}

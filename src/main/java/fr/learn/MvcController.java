package fr.learn;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MvcController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model)
	{
		return "login";
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(Model model)
	{
		
		return "index";
	}
}

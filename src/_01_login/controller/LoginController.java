package _01_login.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {

	private Authenticator authenticator;
	
	@ModelAttribute("login")
	public LoginCommand formbacking() {
		return new LoginCommand();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "_01_login/loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("login") LoginCommand loginCommand, BindingResult result) {
		new LoginCommandValidator().validate(loginCommand, result);
		if(result.hasErrors()) {
			return "_01_login/loginForm";
		}
		try {
			authenticator.authenticate(loginCommand.getId(), loginCommand.getPassword());
			return "_01_login/loginSuccess";
		}catch(AuthenticationException ex) {
			result.reject("invalidIdOrPassword", new Object[] {loginCommand.getId()}, null);
			return "_01_login/loginForm";
		}
	}
	
	@ModelAttribute("loginTypes")
	protected List<String> referenceDate() throws Exception {
		List<String> loginTypes = new ArrayList<String>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터회원");
		return loginTypes;
	}
	
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}
}

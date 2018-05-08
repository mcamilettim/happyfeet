package cl.camiletti.happyFeetWeb.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Usuario;
import cl.camiletti.happyFeetWeb.service.PacienteService;
import cl.camiletti.happyFeetWeb.service.ParametroService;
import cl.camiletti.happyFeetWeb.service.PodologoService;
import cl.camiletti.happyFeetWeb.service.UsuarioService;
import cl.camiletti.happyFeetWeb.util.Mail;
import cl.camiletti.happyFeetWeb.util.StringEncrypt;
import cl.camiletti.happyFeetWeb.util.VerifyRecaptcha;

@Controller
@SessionAttributes(value = { "podologo", "paciente"})
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ParametroService parametroService;

	@Autowired
	private PodologoService podologoService;
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private Environment env;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new Usuario());
		return "paciente/registrationPaciente";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") Usuario userForm, BindingResult bindingResult, Model model) {

		return "";
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Usuario o password inválidos..");

		if (logout != null)
			model.addAttribute("mensaje", "Sesion cerrada exitosamente.");

		return "index";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Usuario o password inválidos.");

		if (logout != null)
			model.addAttribute("message", "Sesion cerrada.");

		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public void login(@ModelAttribute("loginForm") Usuario loginForm, BindingResult bindingResult, Model model) {
		// userValidator.validate(loginForm, bindingResult);
		Usuario usuario = usuarioService.login(loginForm);
		model.addAttribute("loginForm", usuario);
	}

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public ModelAndView welcome(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		GrantedAuthority role = user.getAuthorities().iterator().next();
		String rol = role.toString();

		List<Parametro> parametros = parametroService.findAll();

		for (Parametro parametro : parametros) {
			if (parametro.getValor().equals(rol)) {
				if(rol.equalsIgnoreCase("podologo")) {
					Podologo podologo = podologoService.findByEmail(user.getUsername());
					model.addAttribute("podologo", podologo);
				}
				if(rol.equalsIgnoreCase("paciente")) {
					Paciente paciente = pacienteService.findByEmail(user.getUsername());
					model.addAttribute("paciente", paciente);
				}	
				return new ModelAndView("redirect:" + rol.toLowerCase() + "/index");
			}
		}
		return null;

	}

	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String olvide(Model model) {

		return "forgot";

	}

	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public String verificarOlvide(Model model, @RequestParam("email") String email, HttpServletRequest request) {

		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		try {
			if (!VerifyRecaptcha.verify(gRecaptchaResponse, VerifyRecaptcha.SECRET)) {
				request.setAttribute("error", "Se requiere la verificación de reCAPTCHA.");
				return "forgot";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Usuario user = usuarioService.findByEmail(email);
		if (user != null) {
			Mail mail = new Mail(env);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String link = env.getProperty("verify.link.link");
			String hash = true + ";" + sdf.format(new Date()) + ";" + email;
			try {
				StringEncrypt encrypt = new StringEncrypt(env);
				link = link.concat("recuperarclave?v=" + URLEncoder.encode(encrypt.encrypt(hash), "UTF-8"));
			} catch (Exception e) {
				System.out.println(e);
			}
			if (mail.sendEmailRecover(email, "", link, "", null)) {
				request.setAttribute("exito", "Su acceso fue enviado a su correo electrónico.");
			} else {
				// LOG.error("solicitarclave - No se ha podido enviar el correo a "+email);
			}
		} else {
			// LOG.error("solicitarclave - Usuario ingresado NO CORRESPONDE: "+email);
			request.setAttribute("error", "Los datos ingresados no corresponden.");
		}

		return "forgot";

	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public void logout(HttpSession session, Model model) {

		if (session != null) {
			session.invalidate();
			session.removeAttribute("valida");
		}
		model.addAttribute("index");
	}

}

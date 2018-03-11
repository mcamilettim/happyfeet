package cl.camiletti.happyFeetWeb.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.camiletti.happyFeetWeb.model.Usuario;
import cl.camiletti.happyFeetWeb.service.UsuarioService;
import cl.camiletti.happyFeetWeb.util.StringEncrypt;

@Controller
@Configuration
@PropertySource("classpath:application.properties")
public class VerifyController {

	@Autowired
	private Environment env;
	
    @Autowired
    private UsuarioService usuarioService;
	
	@RequestMapping(value = {"/recuperarclave", "/bienvenido"}, method = RequestMethod.GET)
	public String recuperarclave(@RequestParam("v") String verify,
    		HttpServletRequest request, 
			HttpServletResponse response){
		try {
			//dataSplit[] = boolean;fecha;user;
			//String param = URLDecoder.decode(verify, "UTF-8");
			String data = new StringEncrypt(env).decrypt(verify);
			String[] dataArray = data.split(";");
			boolean vencimiento = Boolean.valueOf(dataArray[0]);
			if(vencimiento) {
				//verificar fecha vencida
				//long longPasado = Long.valueOf(dataArray[1]);
				
				Integer tiempoExpiracion = Integer.valueOf(env.getProperty("verify.link.timelimit"));
				
				Calendar dateActual = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				
				Calendar calendarPasada = Calendar.getInstance();
				Date fechaPasada = sdf.parse(dataArray[1]);
				calendarPasada.setTime(fechaPasada);
				calendarPasada.add(Calendar.MINUTE, tiempoExpiracion);
				//tiempoExpiracion = tiempoExpiracion * 60 * 1000;
				
				if(dateActual.after(calendarPasada)) {
					request.setAttribute("error", "Link de cambio contraseña expirado!");
					return "index";
					
				}
			}
			String user = dataArray[2];
			request.getSession().setAttribute("valida", user);
		} catch (Exception e) {
			//LOG.error("POSIBLE HACK intento obtener clave sin autorizacion recuperarclave GET con key: "+verify+ " host/ip: "+request.getRemoteAddr());
			request.setAttribute("error", "");
			return "index";
		}
		
		//request.setAttribute("exito", "Contraseña cambiada exitosamente.");
		return "cambioclave";
	}
	
	@RequestMapping(value = "/recuperarclave", method = RequestMethod.POST)
	public String recuperarclavePost(@RequestParam("pass") String pass,
			@RequestParam("pass2") String pass2,
    		HttpServletRequest request, 
			HttpServletResponse response){
		
		try {
			if(pass.equals(pass2)) {
//				if(pass.length() < 8 || pass.length() > 20) {
//					request.setAttribute("error", "La contraseña debe tener 8 caracteres como mínimo y 20 carateres máximo.");
//					return "cambio-clave";
//				}
			} else {
				request.setAttribute("error", "Las contraseñas no son iguales.");
				return "cambioclave";
			}
			String user = (String) request.getSession().getAttribute("valida");
			if(user != null) {
				Usuario usuario = usuarioService.findByEmail(user);
				if(usuario != null) {
					usuario.setPassword(pass);
					usuario.setPasswordConfirm(pass);
					usuarioService.save(usuario);
					request.setAttribute("mensaje", "Contraseña cambiada correctamente.");
					return "login";
				} else {
					request.setAttribute("error", "Hubo un error en cambiar la contraseña. Contáctese con el administrador.");
					return "cambioclave";
				}
			} else {
				//Util.noAccess(request, response, "POSIBLE HACK intento cambiarclave sin autorizacion POST con password: "+pass+" con user sesion:"+user, LOG);
				return "index";
			}
		} catch (Exception e) {
			//LOG.error(e);
			return "index";
		}
	}
	  
}

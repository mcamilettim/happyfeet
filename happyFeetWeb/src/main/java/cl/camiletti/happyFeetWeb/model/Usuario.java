package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String email;

	private String password;

	private String passwordConfirm;
 
	//bi-directional many-to-one association to Parametro
	@ManyToOne
	@JoinColumn(name="paramTipoUsuario_id")
	private Parametro paramTipoUsuario;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return this.passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
   
	 

	public Parametro getParamTipoUsuario() {
		return this.paramTipoUsuario;
	}

	public void setParamTipoUsuario(Parametro paramTipoUsuario) {
		this.paramTipoUsuario = paramTipoUsuario;
	}

}
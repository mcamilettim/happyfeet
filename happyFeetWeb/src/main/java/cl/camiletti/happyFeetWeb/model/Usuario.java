package cl.camiletti.happyFeetWeb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String email;

	private String password;

	private String passwordConfirm;

	//bi-directional many-to-one association to Paciente
	@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER)
	private List<Paciente> pacientes;

	//bi-directional many-to-one association to Podologo
	@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER)
	private List<Podologo> podologos;

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

	public List<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Paciente addPaciente(Paciente paciente) {
		getPacientes().add(paciente);
		paciente.setUsuario(this);

		return paciente;
	}

	public Paciente removePaciente(Paciente paciente) {
		getPacientes().remove(paciente);
		paciente.setUsuario(null);

		return paciente;
	}

	public List<Podologo> getPodologos() {
		return this.podologos;
	}

	public void setPodologos(List<Podologo> podologos) {
		this.podologos = podologos;
	}

	public Podologo addPodologo(Podologo podologo) {
		getPodologos().add(podologo);
		podologo.setUsuario(this);

		return podologo;
	}

	public Podologo removePodologo(Podologo podologo) {
		getPodologos().remove(podologo);
		podologo.setUsuario(null);

		return podologo;
	}

	public Parametro getParamTipoUsuario() {
		return this.paramTipoUsuario;
	}

	public void setParamTipoUsuario(Parametro paramTipoUsuario) {
		this.paramTipoUsuario = paramTipoUsuario;
	}

}
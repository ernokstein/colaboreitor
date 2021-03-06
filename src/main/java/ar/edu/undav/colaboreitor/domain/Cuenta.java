package ar.edu.undav.colaboreitor.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cuenta implements Authentication {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	protected String username;
	protected String password;
	protected String nombreReal;
	protected BigDecimal lng;
	protected BigDecimal lat;
	protected long dni;
	protected Timestamp creacion;
    private String passwordConfirm;
    
	@ManyToOne
	@JoinColumn(name="cp")
	protected Cp cp;

	@OneToMany(targetEntity=Incidente.class, mappedBy="cuenta", cascade=CascadeType.ALL, orphanRemoval=true)
	protected List<Incidente> incidentes;

	@OneToMany(targetEntity=Reaccion.class, mappedBy="cuenta", cascade=CascadeType.ALL, orphanRemoval=true)
	protected List<Reaccion> reacciones;

	
	public Cuenta() {
		super();
	}

	public Cuenta(String username, String password, String nombreReal, Cp cp,
			BigDecimal lng, BigDecimal lat,
			long dni, Timestamp creacion) {
		super();
		this.username = username;
		this.password = password;
		this.nombreReal = nombreReal;
		this.cp = cp;
		this.lng = lng;
		this.lat = lat;
		this.dni = dni;
		this.creacion = creacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

	public String getNombreReal() {
		return nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public Cp getCp() {
		return cp;
	}

	public void setCp(Cp cp) {
		this.cp = cp;
	}

	public BigDecimal getLng() {
		return lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public Timestamp getCreacion() {
		return creacion;
	}

	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}

	public List<Incidente> getIncidentes() {
		return incidentes;
	}

	public void setIncidentes(List<Incidente> incidentes) {
		this.incidentes = incidentes;
	}

	public List<Reaccion> getReacciones() {
		return reacciones;
	}

	public void setReacciones(List<Reaccion> reacciones) {
		this.reacciones = reacciones;
	}

	@Override
	public String getName() {
		return username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public Object getCredentials() {
		return password;
	}

	@Override
	public Object getDetails() {
		return this;
	}

	@Override
	public Object getPrincipal() {
		return this;
	}

	@Override
	public boolean isAuthenticated() {
		return true;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		
	}

	@Override
	public String toString() {
		return this.username;
	}
	
}
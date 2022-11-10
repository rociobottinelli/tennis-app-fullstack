package com.baufest.tennis.springtennis.model;

import com.baufest.tennis.springtennis.enums.Estado;
import org.json.JSONObject;
import javax.persistence.*;
import java.util.Date;

/**
 * <p>Entidad Partido</p>
 * Esta entidad sera la que mapee el JPA para transformarlo en una tabla con sus respectivas columnas.
 */
@Entity
@Table(name = "partido")
public class Partido {

	/**
	 * <p>Clase Partido</p>
	 * Declaramos los atributos que va tener nuestro objeto.
	 *
	 * @param id
	 * Accesibilidad: private.
	 * Tipo de dato: Long (No es lo mismo que el primitivo long).
	 * @param fechaComienzo
	 * Accesibilidad: private.
	 * Tipo de dato: Date (Tipo de dato importado de la libreria java.util.Date | Linea 6).
	 * @param estado
	 * Accesibilidad: private.
	 * Tipo de dato: Estado (Tipo de dato definido por nosotros dentro de la carpeta enums
	 * e importado | linea 3).
	 * @param jugadorLocal
	 * Accesibilidad: private.
	 * Tipo de dato: Jugador (Modelo de objeto definido por nosotros).
	 * @param jugadorVisitante
	 * Accesibilidad: private.
	 * Tipo de dato: Jugador (Modelo de objeto definido por nosotros).
	 * @param scoreLocal
	 * Accesibilidad: private.
	 * Tipo de dato: int.
	 * @param puntosGameActualLocal
	 * Accesibilidad: private.
	 * Tipo de dato: String.
	 * @param cantidadGamesLocal
	 * Accesibilidad: private.
	 * Tipo de dato: int.
	 * @param scoreVisitante
	 * Accesibilidad: private.
	 * Tipo de dato: int.
	 * @param puntosGameActualVisitante
	 * Accesibilidad: private.
	 * Tipo de dato: String.
	 * @param cantidadGamesVisitante
	 * Accesibilidad: private.
	 * Tipo de dato: int.
	 */

	/*Atributos privados de la clase*/

	@Id /* Sera el index de nuestra tabla */
	@GeneratedValue(strategy = GenerationType.IDENTITY) /* Valor Auto-generado con la estategia: GenerationType.IDENTITY */
	private Long id;

	@Column(nullable = false)
	private Date fechaComienzo;

	@Column(nullable = false)
	private Estado estado;

	/*
	* En los ManyToOne, OneToOne, OneToMany se producen las relaciones entre las tablas
	* al momento de la construccion de estas por medio del JPA en estos casos se produce una Foreign Key
	* entre dichas tablas estableciendo una relacion, en este caso particular al ser ManyToOne se informa al JPA
	* encargado de construir las tablas que la tabla de Partido contiene un JugadorLocal de este modo se establece
	* que varios Partidos pueden pertenecerle a un JugadorLocal, hay que tener cuidado utilizando estos tags ya que podrian
	* producir la ruptura al momento de compilacion/run */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idLocal", nullable = false)
	private Jugador jugadorLocal;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idVisitante", nullable = false)
	private Jugador jugadorVisitante;

	@Column(nullable = true)
	private int scoreLocal;

	@Column(nullable = true)
	private String puntosGameActualLocal;

	@Column(nullable = true)
	private int cantidadGamesLocal;

	@Column(nullable = true)
	private int scoreVisitante;

	@Column(nullable = true)
	private String puntosGameActualVisitante;

	@Column(nullable = true)
	private int cantidadGamesVisitante;

	/* Construtores de nuestro modelo de dato */

	/* Los constructores se utilizan al momento de instanciar nuesta clase y darle espacio en memoria,
	 * los atributos de nuesta clase que no contengan instanciacion en el constructor quedaran con valor null
	 * los constructores pueden ser overraideados y contener instanciaciones para varios atributos distintos o
	 * incluso el constructor vacio*/


	public Partido() {
	}

	public Partido(Date fechaComienzo, Estado estado, Jugador jugadorLocal, Jugador jugadorVisitante) {
		this.fechaComienzo = fechaComienzo;
		this.estado = estado;
		this.jugadorLocal = jugadorLocal;
		this.jugadorVisitante = jugadorVisitante;
		this.scoreLocal = 0;
		this.puntosGameActualLocal = "0";
		this.cantidadGamesLocal = 0;
		this.scoreVisitante = 0;
		this.puntosGameActualVisitante = "0";
		this.cantidadGamesVisitante = 0;
	}

	public Partido(Long id, Date fechaComienzo, Estado estado, Jugador jugadorLocal, Jugador jugadorVisitante, int scoreLocal, int cantidadGamesLocal, int scoreVisitante, int cantidadGamesVisitante) {
		this.id = id;
		this.fechaComienzo = fechaComienzo;
		this.estado = estado;
		this.jugadorLocal = jugadorLocal;
		this.jugadorVisitante = jugadorVisitante;
		this.scoreLocal = scoreLocal;
		this.cantidadGamesLocal = cantidadGamesLocal;
		this.scoreVisitante = scoreVisitante;
		this.cantidadGamesVisitante = cantidadGamesVisitante;
	}

	public Partido(Date fechaComienzo, Estado estado, Jugador jugadorLocal, Jugador jugadorVisitante, int scoreLocal,
				   String puntosGameActualLocal, int cantidadGamesLocal, int scoreVisitante, String puntosGameActualVisitante,
				   int cantidadGamesVisitante) {
		this.fechaComienzo = fechaComienzo;
		this.estado = estado;
		this.jugadorLocal = jugadorLocal;
		this.jugadorVisitante = jugadorVisitante;
		this.scoreLocal = scoreLocal;
		this.puntosGameActualLocal = puntosGameActualLocal;
		this.cantidadGamesLocal = cantidadGamesLocal;
		this.scoreVisitante = scoreVisitante;
		this.puntosGameActualVisitante = puntosGameActualVisitante;
		this.cantidadGamesVisitante = cantidadGamesVisitante;
	}

	/* Getters & Setters */

	/* Los getters y setters se utilizan para acceder a los atributos de nuestro objeto,
	como estos son PRIVADOS solo pueden ser accedidos desde metodos publicos, los cuales llamamos
	getters y setters, estos permiten modificar o obtener los atributos privados de la clase,
	si queremos que un atributo no sea accesible para cambio ni obtenerlo simplemente borramos el getter
	y el setter, de forma natural no habria forma de acceder a dicho atributo fuera de la instanciacion
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaComienzo() {
		return fechaComienzo;
	}

	public void setFechaComienzo(Date fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Jugador getJugadorLocal() {
		return jugadorLocal;
	}

	public void setJugadorLocal(Jugador jugadorLocal) {
		this.jugadorLocal = jugadorLocal;
	}

	public Jugador getJugadorVisitante() {
		return jugadorVisitante;
	}

	public void setJugadorVisitante(Jugador jugadorVisitante) {
		this.jugadorVisitante = jugadorVisitante;
	}

	public int getScoreLocal() {
		return scoreLocal;
	}

	public void setScoreLocal(int scoreLocal) {
		this.scoreLocal = scoreLocal;
	}

	public String getPuntosGameActualLocal() {
		return puntosGameActualLocal;
	}

	public void setPuntosGameActualLocal(String puntosGameActualLocal) {
		this.puntosGameActualLocal = puntosGameActualLocal;
	}

	public int getCantidadGamesLocal() {
		return cantidadGamesLocal;
	}

	public void setCantidadGamesLocal(int cantidadGamesLocal) {
		this.cantidadGamesLocal = cantidadGamesLocal;
	}

	public int getScoreVisitante() {
		return scoreVisitante;
	}

	public void setScoreVisitante(int scoreVisitante) {
		this.scoreVisitante = scoreVisitante;
	}

	public String getPuntosGameActualVisitante() {
		return puntosGameActualVisitante;
	}

	public void setPuntosGameActualVisitante(String puntosGameActualVisitante) {
		this.puntosGameActualVisitante = puntosGameActualVisitante;
	}

	public int getCantidadGamesVisitante() {
		return cantidadGamesVisitante;
	}

	public void setCantidadGamesVisitante(int cantidadGamesVisitante) {
		this.cantidadGamesVisitante = cantidadGamesVisitante;
	}


	/* Metodo para retornar nuestro modelo de datos en formato de String */
	@Override
	public String toString() {
		return "partido [id=" + id + ", fechaComienzo=" + fechaComienzo + ", estado=" + estado + ", jugadorLocal="
				+ jugadorLocal + ", jugadorVisitante=" + jugadorVisitante + ", scoreLocal=" + scoreLocal
				+ ", puntosGameActualLocal=" + puntosGameActualLocal + ", cantidadGamesLocal=" + cantidadGamesLocal
				+ ", scoreVisitante=" + scoreVisitante + ", puntosGameActualVisitante=" + puntosGameActualVisitante
				+ ", cantidadGamesVisitante=" + cantidadGamesVisitante + "]";
	}

	/* Metodo para retornar nuestro modelo de datos en un formato JSON */
	/* Metodo para retornar nuestro objeto en un formato JSON */
	/*Este metodo es muy utilizado para poder transformar el objeto a JSON en caso de ser necesario para retorno*/
	public JSONObject toJSONObject() {
		JSONObject jo = new JSONObject();
		jo.put("id", getId());
		jo.put("fechaComienzo", getFechaComienzo());
		jo.put("estado", getEstado());
		jo.put("jugadorLocal",getJugadorLocal());
		jo.put("jugadorVisitante",getJugadorVisitante());
		jo.put("scoreLocal", getScoreLocal());
		jo.put("puntosGameActualLocal", getPuntosGameActualLocal());
		jo.put("cantidadGamesLocal", getCantidadGamesLocal());
		jo.put("scoreVisitante", getScoreVisitante());
		jo.put("puntosGameActualVisitante", getPuntosGameActualVisitante());
		jo.put("cantidadGamesVisitante", getCantidadGamesVisitante());
		return jo;
	}
}

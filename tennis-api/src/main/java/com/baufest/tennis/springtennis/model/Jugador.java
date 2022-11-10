package com.baufest.tennis.springtennis.model;

import org.json.JSONObject;
import javax.persistence.*;

/**
 * <p>Entidad Jugador</p>
 * Esta entidad sera la que mapee el JPA para transformarlo en una tabla con sus respectivas columnas.
 */
@Entity
@Table(name = "Jugador")
public class Jugador{

	/**
	 * <p>Clase Partido</p>
	 * Declaramos los atributos que va tener nuestro objeto.
	 *
	 * @param id
	 * Accesibilidad: private.
	 * Tipo de dato: Long (No es lo mismo que el primitivo long).
	 * @param nombre
	 * Accesibilidad: private.
	 * Tipo de dato: String.
	 * @param puntos
	 * Accesibilidad: private.
	 * Tipo de dato: int.
	 */

	/*Atributos privados de la clase*/

	@Id /* Sera el index de nuestra tabla */
	@GeneratedValue(strategy = GenerationType.IDENTITY) /* Valor Auto-generado con la estategia: GenerationType.IDENTITY */
	private Long id;

	@Column(nullable = false) /* No podemos recibir este valor como nulo "null" */
	private String nombre;

	@Column(nullable = false)
	private int puntos;

	/* Construtores de nuestro modelo de dato */

	/* Los constructores se utilizan al momento de instanciar nuesta clase y darle espacio en memoria,
	 * los atributos de nuesta clase que no contengan instanciacion en el constructor quedaran con valor null
	 * los constructores pueden ser overraideados y contener instanciaciones para varios atributos distintos o
	 * incluso el constructor vacio*/

	public Jugador(){} //Por ejemplo aca tenemos un constructor vacio
	public Jugador(String nombre, int puntos) { //Aca un constructor con solo dos parametros instanciados
		this.nombre = nombre;
		this.puntos = puntos;
	}

	public Jugador(Long id, String nombre, int puntos) { //Aca un constructor con tres parametros instanciados
		this.id = id;
		this.nombre = nombre;
		this.puntos = puntos;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	/* Metodo para retornar nuestro objeto en un formato JSON */
	/*Este metodo es muy utilizado para poder transformar el objeto a JSON en caso de ser necesario para retorno*/
	public JSONObject toJSONObject() {
		JSONObject jo = new JSONObject();
		jo.put("id",getId());
		jo.put("nombre",getNombre());
		jo.put("puntos",getPuntos());
		return jo;
	}

}


/*Esta interfaz es un subtipo de CrudRepository que es parte de JPA lo que genera una clase de implemetación en tiempo real*/
package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.unah.bbddI.model.Usuario;
 
public interface RepositoryUsuario extends CrudRepository<Usuario, Integer> {
 
	//El siguiente método se utiliza para la autenticación por Spring security usando una consulta para obtener el nombre de usuario
    @Query("SELECT u FROM Usuario u WHERE u.nomUsuario = :nomUsuario")
    public Usuario getUserByUsername(@Param("nomUsuario") String nomUsuario);
}

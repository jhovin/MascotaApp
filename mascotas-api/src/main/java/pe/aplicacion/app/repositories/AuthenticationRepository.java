package pe.aplicacion.app.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pe.aplicacion.app.entities.Usuario;

@Repository
public class AuthenticationRepository {
		
private static final Logger logger = LoggerFactory.getLogger(AuthenticationRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Usuario login(String correo, String password) throws Exception {
		logger.info("login("+correo+", "+password+")");
		
		String sql = "select count(*) from usuarios where correo=? and password=?";
		
		Integer exists = jdbcTemplate.queryForObject(sql, Integer.class,correo, password);
		
		if(exists == 0) {
			throw new Exception("Usuario y/o clave invalido");
		}
		
		return findByUsername(correo);
	}
	
	public Usuario findByUsername(String correo) throws EmptyResultDataAccessException {
		logger.info("findByUsername("+correo+")");
		
		String sql = "select * from usuarios where correo=?";
		
		Usuario usuario = jdbcTemplate.queryForObject(sql, new RowMapper<Usuario>() {
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setPassword(rs.getString("password"));
				
				return usuario;
			}
		}, correo);
		
		logger.info("user: " + usuario);
		
		return usuario;
	}
	
}




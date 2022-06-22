package com.ms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ms.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static final String INSERT_USER_QUERY = "INSERT INTO user(id,first_name,last_name,email) VALUES(?,?,?,?)";
	private static final String UPDATE_USER_BY_ID_QUERY = "UPDATE user SET first_name=? WHERE id=?";
	private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM user WHERE id=?";
	private static final String DELETE_USER_BY_ID_QUERY = "DELETE FROM user WHERE id=?";
	private static final String GET_USERS_QUERY = "SELECT * FROM user";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User saveUser(User user) {
		jdbcTemplate.update(INSERT_USER_QUERY, user.getId(), user.getFirst_name(), user.getLast_name(),
				user.getEmail());
		return user;
	}

	@Override
	public User updateUser(User user) {
		jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY, user.getFirst_name(), user.getId());
		return user;
	}

	@Override
	public User getById(int id) {
		
		return (User) jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rowNum)->{
			return new User(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("email"));
		},id);
	}

	@Override
	public String deleteById(int id) {
		jdbcTemplate.update(DELETE_USER_BY_ID_QUERY, id);
		return "user got deleted";
	}

	@Override
	public List<User> allUsers() {
		return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum)->{
			return new User(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("email"));
		});
	}

}

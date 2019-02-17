package com.db.spring.app.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.db.spring.app.model.Contact;

public class ContactDAOImpl implements ContactDAO {

	private static final Logger logger = LogManager.getLogger(ContactDAOImpl.class);
	private JdbcTemplate jdbcTemplate;

	public ContactDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void saveOrUpdate(Contact contact) {
		 logger.debug("Debug log message");
	        logger.info("Info log message");
	        logger.error("Error log message");
		if (contact.getId() > 0) {
			// update
			String sql = "UPDATE contact SET name=?, email=?, address=?, " + "telephone=? WHERE contact_id=?";
			jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(),
					contact.getTelephone(), contact.getId());
		} else {
			// insert
			String sql = "INSERT INTO contact (name, email, address, telephone)" + " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(),
					contact.getTelephone());
		}

	}

	public void delete(int contactId) {
		String sql = "DELETE FROM contact WHERE contact_id=?";
		jdbcTemplate.update(sql, contactId);
	}

	public Contact get(int contactId) {
		String sql = "SELECT * FROM contact WHERE contact_id=" + contactId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Contact>() {

			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Contact contact = new Contact();
					contact.setId(rs.getInt("contact_id"));
					contact.setName(rs.getString("name"));
					contact.setEmail(rs.getString("email"));
					contact.setAddress(rs.getString("address"));
					contact.setTelephone(rs.getString("telephone"));
					return contact;
				}

				return null;
			}

		});
	}

	public List<Contact> list() {
		String sql = "SELECT * FROM contact";
		List<Contact> listContact = jdbcTemplate.query(sql, new RowMapper<Contact>() {

			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contact aContact = new Contact();

				aContact.setId(rs.getInt("contact_id"));
				aContact.setName(rs.getString("name"));
				aContact.setEmail(rs.getString("email"));
				aContact.setAddress(rs.getString("address"));
				aContact.setTelephone(rs.getString("telephone"));

				return aContact;
			}

		});

		return listContact;
	}

}

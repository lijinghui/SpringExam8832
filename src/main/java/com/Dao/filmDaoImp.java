package com.Dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class filmDaoImp implements filmDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	

	public void setJdbcTemplate(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public void saveFilm(String title, String description, int language_id) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String str = sdf.format(date);
		try{
		String SQL = "INSERT INTO film(title,description,language_id,last_update) VALUES(?,?,?,?)";
		jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(SQL, title, description, language_id, str);
		System.out.println("插入数据");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(jdbcTemplate);
		}
	}

}

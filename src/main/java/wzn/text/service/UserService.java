package wzn.text.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import wzn.text.bean.AdminUser;

@Service
public class UserService {
	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	public List<AdminUser> findAdmin(){
		return (List<AdminUser>)JdbcTemplate.query("select * from adminuser", new RowMapper<AdminUser>(){

            @Override
            public AdminUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            	AdminUser user = new AdminUser();
                user.setId(rs.getInt("ID"));
                user.setPassWord(rs.getString("USERNAME"));
                user.setPower(rs.getString("PASSWORD"));
                user.setPower(rs.getString("POWER"));
                return user;
            }

        });
	}
}

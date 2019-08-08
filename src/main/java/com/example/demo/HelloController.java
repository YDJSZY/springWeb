package com.example.demo;
import com.example.demo.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class HelloController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/hello")
    public String hello() {
        String sql = "SELECT * FROM users";
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
            User user;
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        });
        for(User user:userList){
            System.out.println(user.getUsername());
        }
        return "user";
    }
}

package com.example.demo;
//import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.Student;
import com.example.demo.domain.repository.StudentRepository;
import javafx.scene.canvas.GraphicsContext;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private StudentRepository studentRepository;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/saveStudent")
    public String saveStudent() {
        /*String sql = "SELECT * FROM users";
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
        return "user";*/
        studentRepository.save(new Student("lww", 26));
        return "Student";
    }
}

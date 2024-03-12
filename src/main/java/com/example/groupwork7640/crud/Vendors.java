package com.example.groupwork7640.crud;

import com.example.groupwork7640.api_service.dto.VendorsDto;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Vendors {

    @Resource
    JdbcTemplate jdbcTemplate;

    public List<VendorsDto> queryAll() {
        String sql = "SELECT * FROM vendors";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(VendorsDto.class));
    }

    public String create(VendorsDto vendorsDto) {
        String sql = "INSERT INTO vendors (name, feedback_score, location) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, vendorsDto.getName(), vendorsDto.getFeedbackScore(), vendorsDto.getLocation());
        return "Success";
    }
}

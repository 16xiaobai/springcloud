package com.boonya.sbsqlite.service.impl;

import com.boonya.sbsqlite.config.DynamicDataSource;
import com.boonya.sbsqlite.service.XhBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class XhBusinessServiceImpl implements XhBusinessService {

    @Autowired
    @Qualifier("sqliteJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public Map<String,Object> select(long id) {
        String sql="SELECT * FROM TableBusiness WHERE id="+id;
        return jdbcTemplate.queryForList(sql).get(0);
    }

    public List<Map<String,Object>> selectAll() {
        String sql="SELECT * FROM TableBusiness";
        return jdbcTemplate.queryForList(sql);
    }

}
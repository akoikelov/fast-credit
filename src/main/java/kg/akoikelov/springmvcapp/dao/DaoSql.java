package kg.akoikelov.springmvcapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DaoSql implements Dao{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public boolean checkById(String tableName, int id) {
        String sql = "Select count(*) from "+tableName+ " where id=?";
        Integer count= jdbcTemplate.queryForObject(sql,Integer.class,id);
        return count!=null&&count>0;
    }
}

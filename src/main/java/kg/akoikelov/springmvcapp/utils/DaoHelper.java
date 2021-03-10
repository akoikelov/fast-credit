package kg.akoikelov.springmvcapp.utils;

import org.springframework.jdbc.core.JdbcTemplate;

public class DaoHelper {

    public static boolean fieldValueExists(
            JdbcTemplate jdbcTemplate, String tableName, String fieldName, Object value, int id) {

        String sql = "select count(*) from " + tableName + " where " + fieldName + " = ?";
        Object[] args = new Object[]{value};

        if (id != 0) {
            sql += " and id != ?";
            args = new Object[]{value, id};
        }

        Integer count = jdbcTemplate.queryForObject(sql, args, Integer.class);

        return count != null && count > 0;
    }
}

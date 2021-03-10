package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.Analytics;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnalyticsMapper implements RowMapper<Analytics> {
    @Override
    public Analytics mapRow(ResultSet resultSet, int i) throws SQLException {
        Analytics analytics = new Analytics();
        analytics.setId(resultSet.getInt("id"));
        analytics.setTitle(resultSet.getString("title"));
        analytics.setComment(resultSet.getString("comment"));
        analytics.setIncome(resultSet.getBoolean("is_income"));
        return analytics;
    }
}

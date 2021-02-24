package kg.akoikelov.springmvcapp.mappers;

import kg.akoikelov.springmvcapp.models.Affiliate;
import kg.akoikelov.springmvcapp.models.CashBox;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CashBoxMapperForList implements RowMapper<CashBox>{
    @Override
    public CashBox mapRow(ResultSet resultSet, int i) throws SQLException {
        CashBox cashBox = new CashBox();
        Affiliate affiliate = new Affiliate();
        affiliate.setTitle(resultSet.getString("aff_title"));
        cashBox.setId(resultSet.getInt("id"));
        cashBox.setTitle(resultSet.getString("title"));
        cashBox.setAffiliate(affiliate);
        cashBox.setComment(resultSet.getString("comment"));
        return cashBox;
    }
}

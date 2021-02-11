package kg.akoikelov.springmvcapp.dao;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
@ComponentScan
public class DAOSqlTest {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        FixtureFactoryLoader.loadTemplates("kg.akoikelov.springmvcapp.factories");
        jdbcTemplate.execute("truncate cashboxes, affiliates, employees, customer cascade"); // очистить таблицы перед каждым тестом
    }

}

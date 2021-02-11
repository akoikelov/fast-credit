package kg.akoikelov.springmvcapp.factories;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import kg.akoikelov.springmvcapp.models.Employee;

import java.util.Date;

public class EmployeeTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Employee.class).addTemplate("valid", new Rule() {{
            add("userName", "employee");
            add("password", "password");
            add("fullName", "full_name");
            add("position", "position");
            add("salary", random(100, 1000, 100000));
            add("isWorking", random(true, false));
            add("birthday", new Date());
            add("passportId", "passport_id");
            add("comment", "comment");
            add("role", "employee");
            add("address", "address");
            add("phone", "phone");
        }

        });
    }
}

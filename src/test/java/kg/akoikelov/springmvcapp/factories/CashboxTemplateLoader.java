package kg.akoikelov.springmvcapp.factories;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import kg.akoikelov.springmvcapp.models.CashBox;

public class CashboxTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(CashBox.class).addTemplate("valid", new Rule(){{
            add("title", "Some title");
            add("comment", "some comment");
        }});
    }
}

package kg.akoikelov.springmvcapp.factories;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import kg.akoikelov.springmvcapp.models.Affiliate;

public class AffiliateTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Affiliate.class).addTemplate("valid", new Rule(){{
            add("title", "Some title");
            add("maxSumMonth", random(10, 1000, 10000));
            add("maxSumDay", random(10, 1000, 10000));
            add("maxDays", random(1, 10, 30));
            add("minPercentage", random(0.5f, 0.1f, 1f));
            add("comment", "some comment");
            add("phone", "some phone");
            add("address", "some address");
            add("prefix", "prefix");
            add("maxMonths", random(1, 10, 30));
        }});
    }
}

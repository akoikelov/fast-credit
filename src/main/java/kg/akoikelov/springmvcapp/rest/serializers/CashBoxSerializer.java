package kg.akoikelov.springmvcapp.rest.serializers;

import kg.akoikelov.springmvcapp.dao.CashBoxDAO;
import kg.akoikelov.springmvcapp.models.Affiliate;
import kg.akoikelov.springmvcapp.models.CashBox;
import kg.akoikelov.springmvcapp.validation.Unique;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Unique.List({
        @Unique(fieldName = "title", service = CashBoxDAO.class, message = "Касса с таким именем есть")
})
@Component
public class CashBoxSerializer {

    public Map<Integer, String> affiliates = new HashMap<>();

    /**
     * Primary Key
     */
    private int id;
    /**
     * Title
     */
    @NotNull
    @NotBlank
    private String title;
    /**
     * Affiliate
     */
    /**
     * Comment
     */
    private String comment;

    private int affiliateId;

    public CashBoxSerializer(CashBox cashBox) {
        this.id = cashBox.getId();
        this.title = cashBox.getTitle();
        this.affiliateId = cashBox.getAffiliateId();
        this.comment = cashBox.getComment();
    }

    public CashBoxSerializer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(int affiliateId) {
        this.affiliateId = affiliateId;
    }

    public Map<Integer, String> getAffiliates() {
        return affiliates;
    }

    public void setAffiliates(List<Affiliate> affiliatesList) {
        for (Affiliate affiliate : affiliatesList) {
            affiliates.put(affiliate.getId(), affiliate.getTitle());
        }
    }

    public CashBox build(String title) {

        return new CashBox(title, comment, affiliateId);
    }
    public CashBox build() {

        return new CashBox(title, comment, affiliateId);
    }
}
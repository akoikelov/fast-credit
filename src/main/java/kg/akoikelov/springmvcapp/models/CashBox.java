package kg.akoikelov.springmvcapp.models;

public class CashBox {
    /**
     * Primary Key
     */
    private int id;
    /**
     * Title
     */
    private String title;
    /**
     * Affiliate
     */
    private Affiliate affiliate;
    /**
     * Comment
     */
    private String comment;

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Affiliate getAffiliate() {
        return affiliate;
    }

    public void setAffiliate(Affiliate affiliate) {
        this.affiliate = affiliate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

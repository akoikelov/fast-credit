package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.models.Affiliate;

import java.util.List;

public interface AffiliatesDAO {


    public Affiliate findById(int id);

    public boolean create(Affiliate affiliate);

    public boolean update(Affiliate affiliate);

    public boolean delete(int id);

}

package kg.akoikelov.springmvcapp.dao;

import kg.akoikelov.springmvcapp.models.Affiliate;

import java.util.List;

public interface AffiliatesDAO {


    public Affiliate findById(int id);

    public List<Affiliate> findAll();

    public boolean create(Affiliate affiliate);

    public boolean update(int id, Affiliate affiliate);

    public boolean delete(int id);

}

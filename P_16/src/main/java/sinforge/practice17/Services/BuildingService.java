package sinforge.practice17.Services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import sinforge.practice17.Entities.Building;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class BuildingService {
    private Session session;
    public BuildingService(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    public void add(String creationDate, String type) {
        Building building = new Building();
        building.setCreationDate(creationDate);
        building.setType(type);
        var transaction = session.beginTransaction();
        session.saveOrUpdate(building);
        transaction.commit();

    }
    public void delete(String creationDate, String type) {

        var transaction = session.beginTransaction();
        String hql = "delete from Building where creationDate= :creation_date and type= :type";
        session.createQuery(hql).setString("creation_date", creationDate).setString("type", type).executeUpdate();
        transaction.commit();
    }

    public List<Building> getAll() {
        return session.createQuery("select p from Building p",
                Building.class).getResultList();
    }

    public List<Building> filterByCreationDate(String creationDate) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Building> postOfficeCriteriaQuery = builder.createQuery(Building.class);
        Root<Building> root = postOfficeCriteriaQuery.from(Building.class);

        postOfficeCriteriaQuery.select(root).where(builder.equal(root.get("creation_date"), creationDate));
        return session.createQuery(postOfficeCriteriaQuery).getResultList();
    }
    public List<Building> filterByType(String type) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Building> postOfficeCriteriaQuery = builder.createQuery(Building.class);
        Root<Building> root = postOfficeCriteriaQuery.from(Building.class);

        postOfficeCriteriaQuery.select(root).where(builder.equal(root.get("type"), type));
        return session.createQuery(postOfficeCriteriaQuery).getResultList();
    }
}

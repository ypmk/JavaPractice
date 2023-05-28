package sinforge.practice17.Services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import sinforge.practice17.Entities.Address;
import sinforge.practice17.Entities.Building;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component

public class AddressService {
    private Session session;
    public AddressService(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    public void add(String addressText, String zipCode, int buildingId) {
        Address address = new Address();
        address.setAddressText(addressText);
        address.setZipCode(zipCode);
        address.setBuilding(session.load(Building.class, buildingId));
        var transaction = session.beginTransaction();
        session.saveOrUpdate(address);
        transaction.commit();

    }
    public void delete(String addressText, String zipCode) {

        var transaction = session.beginTransaction();
        String hql = "delete from Address where addressText= :address_text and zipCode= :zip_code";
        session.createQuery(hql).setString("address_text", addressText).setString("zip_code", zipCode).executeUpdate();
        transaction.commit();
    }

    public List<Address> getAll() {
        return session.createQuery("select d from Address d",
                Address.class).getResultList();
    }
    public List<Address> filterByAddressText(String addressText) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> queryCriteriaQuery = builder.createQuery(Address.class);
        Root<Address> root = queryCriteriaQuery.from(Address.class);

        queryCriteriaQuery.select(root).where(builder.equal(root.get("address_text"), addressText));
        return session.createQuery(queryCriteriaQuery).getResultList();
    }

    public List<Address> filterByZipCode(String zipCode) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> postOfficeCriteriaQuery = builder.createQuery(Address.class);
        Root<Address> root = postOfficeCriteriaQuery.from(Address.class);

        postOfficeCriteriaQuery.select(root).where(builder.equal(root.get("zip_code"), zipCode));
        return session.createQuery(postOfficeCriteriaQuery).getResultList();
    }



}

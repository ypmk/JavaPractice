package sinforge.practice22.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sinforge.practice22.Entities.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
    Address findByAddressTextAndZipCode(String AddressText, String ZipCode);

}

package sinforge.practice20.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sinforge.practice20.Entities.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
    Address findByAddressTextAndZipCode(String AddressText, String ZipCode);

}

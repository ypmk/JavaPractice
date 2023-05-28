package sinforge.practice19.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sinforge.practice19.Entities.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
    Address findByAddressTextAndZipCode(String AddressText, String ZipCode);

}

package sinforge.practice22.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="addressupdated")
@Getter
@Setter
public class Address {
    @Id
    @SequenceGenerator(name = "address_seq_1", sequenceName =
            "address_seq_1", allocationSize = 1)
    @GeneratedValue(generator = "address_seq_1", strategy =
            GenerationType.SEQUENCE)
    private Integer id;
    @Column(name="address_text")
    private String addressText;
    @Column(name="zip_code")
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "building_id")
    private Building building;


    public Address() {

    }




}

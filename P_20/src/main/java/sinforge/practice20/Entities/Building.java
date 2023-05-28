package sinforge.practice20.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Table(name="buildingupdated")
@Getter
@Setter
public class Building {
    @Id
    @SequenceGenerator(name = "address_seq_1", sequenceName =
            "address_seq_1", allocationSize = 1)
    @GeneratedValue(generator = "address_seq_1", strategy =
            GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="creation_date")
    private String creationDate;
    @Column(name="type")
    private String type;

    @OneToMany(mappedBy = "building")
    private List<Address> addresses;

    public Building(String creationDate, String type) {
        this.creationDate = creationDate;
        this.type = type;
    }

    public Building() {

    }


}

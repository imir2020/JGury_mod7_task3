package by.javagury.spring.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString(exclude = "receiver")
@EqualsAndHashCode(of = "receiver")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payment")
public class Payment implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;


    @ManyToOne(fetch = FetchType.LAZY)//, cascade = CascadeType.ALL
    @JoinColumn(name = "receiver_id")
    private User receiver;

}
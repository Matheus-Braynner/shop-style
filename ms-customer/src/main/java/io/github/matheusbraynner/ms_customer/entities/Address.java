package io.github.matheusbraynner.ms_customer.entities;

import io.github.matheusbraynner.ms_customer.entities.enums.States;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Table(name = "tb_address")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "state")
    private States state;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "cep")
    private String cep;

    @Column(name = "complement")
    private String complement;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
}

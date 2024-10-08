package io.github.matheusbraynner.ms_customer.entities;

import io.github.matheusbraynner.ms_customer.entities.enums.Sex;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@Table(name = "tb_customer")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sex")
    private Sex sex;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Address> addresses;
}

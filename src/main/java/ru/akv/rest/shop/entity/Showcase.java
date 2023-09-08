package ru.akv.rest.shop.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "showcase")
public class Showcase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String name;

    private String address;

    private String type;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "last_date")
    private LocalDate lastDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "showcase")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private List<Product> productList;

}

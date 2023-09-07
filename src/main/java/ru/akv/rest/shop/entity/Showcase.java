package ru.akv.rest.shop.entity;

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
    private int id;

    private String name;

    private String type;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "last_date")
    private LocalDate lastDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "showcase")
    private List<Product> productList;
}

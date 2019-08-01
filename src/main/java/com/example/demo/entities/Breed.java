package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String breedName;

    @OneToMany(mappedBy = "breed",cascade = CascadeType.ALL)
    private List<Dog> dogs;
}


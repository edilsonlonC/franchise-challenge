package com.challenge.franchise.infrastructure.database.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "branches")
public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
    private List<ProductEntity> products;
    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private FranchiseEntity franchise;
}

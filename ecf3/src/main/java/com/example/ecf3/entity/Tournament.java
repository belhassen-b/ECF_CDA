package com.example.ecf3.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String dateTime;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
    private List<Game> games;

}

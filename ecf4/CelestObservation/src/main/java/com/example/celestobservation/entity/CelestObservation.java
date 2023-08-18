package com.example.celestobservation.entity;


import com.example.authentication.entity.Utilisateur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "celest_observation")
public class CelestObservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String date;

    private String description;

    private String image;

    @Column(name = "celest_object_id")
    private Long celestObjectId;


    @Column(name = "user_id")
    private Long userId;
}

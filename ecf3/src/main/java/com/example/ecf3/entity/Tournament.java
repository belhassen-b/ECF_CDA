package com.example.ecf3.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
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



    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="date")
    private Date date;

//    @Temporal(TemporalType.DATE)
//    @Column(name="end_date")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date endDate;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
    private List<Game> games;

    public void setDate(java.util.Date date) {
    }
}

package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="country_id", nullable = false)
    private Long id;

    @Column(name ="country")
    //@JsonProperty("country_name")
    private String country_name;

    @Column(name ="create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name ="last_update")
    @UpdateTimestamp
    private Date last_update;
    //test
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country", fetch = FetchType.LAZY)
    private Set<Division> divisions = new HashSet<>();
}

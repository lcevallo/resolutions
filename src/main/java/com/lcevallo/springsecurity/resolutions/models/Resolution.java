package com.lcevallo.springsecurity.resolutions.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resolution" ,schema ="public" )
public class Resolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String text;

    @Column
    private Integer owner;

    @NotNull
    @Column(columnDefinition = "boolean default false")
    private Boolean completed= false;

}

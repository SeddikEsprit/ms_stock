package com.seddik.microservice_project.ms_stock.entities;

import com.seddik_commons.entities.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

@Entity
//lombok annotation
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stock extends BaseEntity {
    private String adresse;

}

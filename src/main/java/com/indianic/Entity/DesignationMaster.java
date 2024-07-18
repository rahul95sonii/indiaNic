package com.indianic.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "designation_master")
public class DesignationMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long designationId;
    private String designationCode;
    private String designationName;


}
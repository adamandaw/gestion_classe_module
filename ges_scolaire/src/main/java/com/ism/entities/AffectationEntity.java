package com.ism.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AffectationEntity {
    private int id;
    private int classe_id;
    private int module_id;
}

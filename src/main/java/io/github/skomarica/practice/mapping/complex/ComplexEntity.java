package io.github.skomarica.practice.mapping.complex;

import io.github.skomarica.practice.mapping.simple.SimpleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sinisa Komarica
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComplexEntity {

    private Integer position;

    private SimpleEntity simpleEntity;
}

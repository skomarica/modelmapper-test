package io.github.skomarica.practice.mapping.simple;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sinisa Komarica
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SimpleEntity {

    private Long id;

    private String name;
}

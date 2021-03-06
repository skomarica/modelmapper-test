package io.github.skomarica.practice.mapping;

import io.github.skomarica.practice.mapping.complex.ComplexEntity;
import io.github.skomarica.practice.mapping.simple.SimpleEntity;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.modelmapper.convention.MatchingStrategies.STRICT;

/**
 * @author Sinisa Komarica
 */
public class MappingTest {

    @Test
    public void mapWhenSimpleEntityMappingNotLearnedMapsFieldToNull() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(STRICT);

        // modelMapper.map(new SimpleEntity(), new SimpleEntity());

        final ComplexEntity newEntity = new ComplexEntity(1, null);
        final ComplexEntity previousEntity = new ComplexEntity(2, new SimpleEntity(3L, "3 Name"));

        modelMapper.map(newEntity, previousEntity);

        System.out.println("ComplexEntity TypeMap mappings = " + modelMapper.getTypeMap(ComplexEntity.class, ComplexEntity.class).getMappings());

        assertThat(previousEntity.getPosition()).isEqualTo(1);
        assertThat(previousEntity.getSimpleEntity()).isNull();
    }

    @Test
    public void mapWhenSimpleEntityMappingLearnedMapsFieldToEmptyInstance() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(STRICT);

        modelMapper.map(new SimpleEntity(), new SimpleEntity());

        final ComplexEntity newEntity = new ComplexEntity(1, null);
        final ComplexEntity previousEntity = new ComplexEntity(2, new SimpleEntity(3L, "3 Name"));

        modelMapper.map(newEntity, previousEntity);

        System.out.println("ComplexEntity TypeMap mappings = " + modelMapper.getTypeMap(ComplexEntity.class, ComplexEntity.class).getMappings());

        assertThat(previousEntity.getPosition()).isEqualTo(1);
        assertThat(previousEntity.getSimpleEntity()).isEqualTo(new SimpleEntity());
    }
}

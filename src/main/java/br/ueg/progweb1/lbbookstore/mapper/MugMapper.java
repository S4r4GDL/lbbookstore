package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.mug.Mug;
import br.ueg.progweb1.lbbookstore.model.mug.dto.MugCreateDTO;
import br.ueg.progweb1.lbbookstore.model.mug.dto.MugDTO;
import br.ueg.progweb1.lbbookstore.model.mug.dto.MugUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MugMapper extends GenericMapper<
        Long,
        Mug,
        MugDTO,
        MugCreateDTO,
        MugUpdateDTO>
{
}
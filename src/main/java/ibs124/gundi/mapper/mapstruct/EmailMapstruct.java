package ibs124.gundi.mapper.mapstruct;

import org.mapstruct.Mapper;

import ibs124.gundi.config.MapperConfig;
import ibs124.gundi.mapper.EmailMapper;
import ibs124.gundi.mapper.UserMapper;

@Mapper(componentModel = MapperConfig.MAPSTRUCT_COMPONENT_MODEL, uses = UserMapper.class)
interface EmailMapstruct extends EmailMapper {

}

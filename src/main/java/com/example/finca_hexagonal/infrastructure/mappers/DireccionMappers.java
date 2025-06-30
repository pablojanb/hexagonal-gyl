package com.example.finca_hexagonal.infrastructure.mappers;

import com.example.finca_hexagonal.domain.models.Direccion;
import com.example.finca_hexagonal.infrastructure.entities.DireccionEntity;
import com.example.finca_hexagonal.infrastructure.repositories.JpaDireccionRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//@Mapper(componentModel = "spring")

public abstract class DireccionMappers {

    //@Autowired
    //JpaDireccionRepository DireccionUserRepository;

    @Mapping(source = "course.id", target = "course", qualifiedByName = "mapCourseIdToCourse")
    @Mapping(source = "user.id", target = "user", qualifiedByName = "mapUserIdToUser")
    public abstract DireccionEntity fromDomainModel(Direccion direccion);


    @Mapping(source = "course", target = "course")
    @Mapping(source = "user", target = "user")
    public abstract Direccion toDomainModel(DireccionEntity direccionEntity);

    public abstract List<DireccionEntity> fromDomainModelList(List<Direccion> course_users);




}


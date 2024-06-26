package br.ueg.progweb1.lbbookstore.controller;

import br.ueg.progweb1.lbbookstore.AppStartupRunner;
import br.ueg.progweb1.lbbookstore.mapper.GenericMapper;
import br.ueg.progweb1.lbbookstore.model.GenericModel;
import br.ueg.progweb1.lbbookstore.service.GenericCrudService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

public abstract class CrudController < MODEL extends GenericModel<PK>,
        PK,
        DTO,
        CreateDTO,
        UpdateDTO,
        SERVICE extends GenericCrudService<PK, MODEL>,
        MAPPER extends GenericMapper< PK, MODEL, DTO, CreateDTO, UpdateDTO> >
        implements GenericCrudController < PK, DTO, CreateDTO, UpdateDTO >{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    SERVICE service;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    MAPPER mapper;

    protected static final Logger LOG =
            LoggerFactory.getLogger(AppStartupRunner.class);

    @PostMapping
    @Operation(description = "End point to create a new item")
    @Override
    public ResponseEntity<DTO> create(@RequestBody CreateDTO createDTO){
        LOG.info("Item to create: {}", createDTO);
        var response = mapper.fromModelToDTO(service.create(mapper.fromCreateDTOToModel(createDTO)));
        LOG.info("Item created: {}", response);
        return ResponseEntity.ok(response);

    }

    @GetMapping(path = "/{id}")
    @Operation(description = "End point to get an item by id: ")
    @Override
    public ResponseEntity<DTO> getItemById(@PathVariable PK id) {

        LOG.info("Id: {}", id);
        var response = mapper.fromModelToDTO(service.getById(id));
        return ResponseEntity.ok(response);

    }


    @PutMapping(path = "/{id}")
    @Operation(description = "End point to update an item")
    @Override
    public ResponseEntity<DTO> update(@RequestBody UpdateDTO updateDTO) {

        LOG.info("Item to update: {}", updateDTO);
        var response = mapper.fromModelToDTO(service.update(mapper.fromUpdateDTOToModel(updateDTO)));
        LOG.info("Item updated: {}", response);
        return ResponseEntity.ok(response);

    }


    @DeleteMapping(path = "/{id}")
    @Operation(description = "End point to delete an item")
    @Override
    public ResponseEntity<DTO> delete(@PathVariable("id") PK id) {

        DTO response = mapper.fromModelToDTO(service.delete(id));
        LOG.info("Item deleted: {}", response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "End point to delete items")
    @Override
    public ResponseEntity<List<DTO>> deleteItems(@RequestBody List<DTO> items){
        LOG.info("Items to delete: {} ", items);
        List<DTO> response = new ArrayList<>();

        for(DTO item: items) {
            response.add(mapper.fromModelToDTO(service.delete(mapper.fromDTOToModel(item).getId())));
            LOG.info("Item deleted from deleteItems: {}", item);
        }

        return ResponseEntity.ok(response);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "End point to list all items")
    @Override
    public ResponseEntity<List<DTO>> getAllItems(){

        List<DTO>response = mapper.fromModelListToDTOList(service.getAll());
        LOG.info("list: {}", response);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/{id}")
    @Operation(description = "End point to activate or not an item")
    public ResponseEntity<DTO> active(@PathVariable PK id)
    {
        var response = mapper.fromModelToDTO(service.active(id));
        return ResponseEntity.ok(response);
    }

}

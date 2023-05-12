package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dtos.ProjectDTOS.CreateProjectDTO;
import med.voll.api.models.Client;
import med.voll.api.models.Project;
import med.voll.api.services.Clientes.ReadOnlyClientService;
import med.voll.api.services.Projetos.CreateProjectService;
import med.voll.api.services.Projetos.DeleteProjectService;
import med.voll.api.services.Projetos.ReadAllProjectsService;
import med.voll.api.services.Projetos.ReadOnlyProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("projects")

public class ProjectsController {
    @Autowired
    private  CreateProjectService services;

    @Autowired
    private ReadAllProjectsService readsAll;

    @Autowired
    private ReadOnlyProjectsService readOnly;
    @Autowired
    private DeleteProjectService deleteProject;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@RequestBody @Valid CreateProjectDTO createProject){
        return services.execute(createProject);
    }

    @GetMapping
    public List<Project> getAllBoards() {
        return readsAll.execute();
    }
    @GetMapping("{id}")
    public Project getById(@PathVariable String id) {
        return readOnly.execute(Long.valueOf(id));
    }



    //Patch  /projects/{hash}
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        deleteProject.delete(Long.valueOf(id));
    }
}

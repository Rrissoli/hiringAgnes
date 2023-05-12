package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dtos.ActivitiesListDTOS.CreateActivityListDTO;
import med.voll.api.models.Activities_list;
import med.voll.api.models.Activity;
import med.voll.api.services.Activities_List.CreateActivities_ListService;
import med.voll.api.services.Activities_List.ReadActivitiesListForProjectEspecific;
import med.voll.api.services.Activities_List.ReadJustActivitys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("activitieslist")
public class ActivitiesListController {


    @Autowired
    private CreateActivities_ListService services;
    @Autowired
   private ReadActivitiesListForProjectEspecific readActivities_List;
    @Autowired
    private ReadJustActivitys readJustActivitys;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Activities_list create(@RequestBody @Valid CreateActivityListDTO createActivityListDTO){
        return services.execute(createActivityListDTO);
    }
    @GetMapping("{id}")
    public List<Activities_list> getAll(@PathVariable String id){
        return readActivities_List.execute(Long.valueOf(id));
    }
    @GetMapping("{id}/justactivities")
    public List<Activity> getJustActivities(@PathVariable String id){
        return readJustActivitys.execute(Long.valueOf(id));
    }
//    @GetMapping
//    public List<Client> getAllBoards() {
//        return readsAll.execute();
//    }
//    @GetMapping("{id}")
//    public Client getById(@PathVariable String id) {
//        return readOnly.execute(Long.valueOf(id));
//    }



}
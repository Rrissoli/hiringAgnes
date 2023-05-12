package med.voll.api.services.Activities_List;

import lombok.RequiredArgsConstructor;
import med.voll.api.dtos.ActivitiesListDTOS.CreateActivityListDTO;
import med.voll.api.models.Activities_list;
import med.voll.api.models.Project;
import med.voll.api.repositories.Activities_ListRepository;
import med.voll.api.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("projects")
public class ReadActivitiesListForProjectEspecific {
    @Autowired
    private Activities_ListRepository activities_ListRepository;

    @Autowired
    private ProjectsRepository projectsRepository;

    public List<Activities_list> execute(Long id){
        Optional<Project> optionalProject= projectsRepository.findById(id);
        Project project = optionalProject.orElseThrow(() -> new RuntimeException("Não foi encontrado um projeto com o ID informado."));
        List<Activities_list> list = project.getActivitiesLists();
        return list;
    }

}

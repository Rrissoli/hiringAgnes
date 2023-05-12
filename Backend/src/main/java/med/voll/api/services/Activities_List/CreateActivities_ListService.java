package med.voll.api.services.Activities_List;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import med.voll.api.dtos.ActivitiesListDTOS.CreateActivityListDTO;
import med.voll.api.models.Activities_list;
import med.voll.api.models.Client;
import med.voll.api.models.Project;
import med.voll.api.repositories.Activities_ListRepository;
import med.voll.api.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("projects")
public class CreateActivities_ListService {
    @Autowired
    private Activities_ListRepository activities_ListRepository;

    @Autowired
    private ProjectsRepository projectsRepository;
    @Transactional
    public Activities_list execute(CreateActivityListDTO createActivityListDTO){
        Optional<Project> optionalProject= projectsRepository.findById(createActivityListDTO.getProject_id());
        Project project = optionalProject.orElseThrow(() -> new RuntimeException("Não foi encontrado um projeto com o ID informado."));

        Activities_list activitiesList = new Activities_list( createActivityListDTO, project);
        Activities_list saved = activities_ListRepository.save(activitiesList);

        return saved;
    }

}

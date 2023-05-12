package med.voll.api.services.Activity;

import lombok.RequiredArgsConstructor;
import med.voll.api.dtos.Activity.CreateActivityDTO;
import med.voll.api.models.Activities_list;
import med.voll.api.models.Activity;
import med.voll.api.models.Client;
import med.voll.api.repositories.Activities_ListRepository;
import med.voll.api.repositories.ActivityRepository;
import med.voll.api.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("activity")
public class CreateActivityService {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private Activities_ListRepository activitiesListRepository;

    public Activity createActivity(CreateActivityDTO createActivityDTO){
        Optional<Activities_list> optionalActivitiesList = activitiesListRepository.findById(createActivityDTO.getActivities_list_id());
        Activities_list listActivity = optionalActivitiesList.orElseThrow(() -> new RuntimeException("Não foi encontrado um cliente com o ID informado."));
        Activity activity = new Activity(createActivityDTO, listActivity);
        return  activityRepository.save(activity);
    }

}

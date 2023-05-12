package med.voll.api.services.Activities_List;

import lombok.RequiredArgsConstructor;
import med.voll.api.models.Activities_list;
import med.voll.api.models.Activity;
import med.voll.api.models.Project;
import med.voll.api.repositories.Activities_ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("projects")
public class ReadJustActivitys {
    @Autowired
    private Activities_ListRepository activities_ListRepository;

    public List<Activity> execute(Long id){
        Optional<Activities_list> optionalActivitiesList= activities_ListRepository.findById(id);
        Activities_list activities_list = optionalActivitiesList.orElseThrow(() -> new RuntimeException("Não foi encontrado um projeto com o ID informado."));
        List<Activity> list = activities_list.getActivities();
        return list;
    }
}

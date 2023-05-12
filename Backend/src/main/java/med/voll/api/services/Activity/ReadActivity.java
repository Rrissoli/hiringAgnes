package med.voll.api.services.Activity;

import lombok.RequiredArgsConstructor;
import med.voll.api.models.Activity;
import med.voll.api.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("activity")
public class ReadActivity {
    @Autowired
    private ActivityRepository activityRepository;

    public Activity getActivity(Long id) {
        return activityRepository.findById(id).orElse(null);
    }

}

package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dtos.Activity.CreateActivityDTO;
import med.voll.api.dtos.Activity.UpdateStatusDto;
import med.voll.api.enums.Status;
import med.voll.api.models.Activity;
import med.voll.api.repositories.ActivityRepository;
import med.voll.api.services.Activity.CreateActivityService;
import med.voll.api.services.Activity.ReadActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    private CreateActivityService createActivityService;
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ReadActivity readActivity;



    @PostMapping
    public Activity createActivity(@RequestBody @Valid CreateActivityDTO createActivityDTO) {
        return  createActivityService.createActivity(createActivityDTO);
    }
    @GetMapping("{id}")
    public Activity getAll(@PathVariable String id){
        return readActivity.getActivity(Long.valueOf(id));
    }

    @PatchMapping("status/{id}")
    public ResponseEntity<Activity> updateStatusActivity(@PathVariable Long id, @RequestBody UpdateStatusDto updateStatusDto) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);
        if (optionalActivity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Activity activity = optionalActivity.get();

        if (activity.getTitle() != null ) {
            activity.setStatus(updateStatusDto.getStatus());
            activityRepository.save(activity);
        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(activity);
    }


}

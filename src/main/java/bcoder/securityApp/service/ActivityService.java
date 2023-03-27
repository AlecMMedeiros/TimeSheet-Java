package bcoder.securityApp.service;

import bcoder.securityApp.model.ActivityModel;
import bcoder.securityApp.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
  private final ActivityRepository activityRepository;

  public ActivityService (ActivityRepository activityRepository){
    this.activityRepository = activityRepository;
  }

  public ActivityModel simpleSaving ( ActivityModel newActivity ) {
    return activityRepository.save(newActivity);
  }

}

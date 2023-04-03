package bcoder.securityApp.service;

import bcoder.securityApp.model.ActivityModel;
import bcoder.securityApp.repository.ActivityRepository;
import bcoder.securityApp.service.interfaces.IActivityService;
import org.springframework.stereotype.Service;

@Service
public class ActivityService implements IActivityService {
  private final ActivityRepository activityRepository;

  public ActivityService (ActivityRepository activityRepository){
    this.activityRepository = activityRepository;
  }

  public void simpleSaving ( ActivityModel newActivity ) {
    activityRepository.save(newActivity);
  }

}

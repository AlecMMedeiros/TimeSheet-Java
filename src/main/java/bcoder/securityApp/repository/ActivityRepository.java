package bcoder.securityApp.repository;

import bcoder.securityApp.model.ActivityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository< ActivityModel, Long> {
}

package bcoder.securityApp.repository;

import bcoder.securityApp.dto.UserJobDTO;
import bcoder.securityApp.model.JobModel;
import bcoder.securityApp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<UserModel, Long> {
  UserModel findByEmail( String email);

  @Query("SELECT u, j FROM UserModel u JOIN UserJobModel uj ON uj.user = u JOIN JobModel j ON uj.job = j")
  List<Object[]> findAllWithJobsRaw();


  default List<UserJobDTO> findAllWithJobs () {
    List<Object[]> rawResults = findAllWithJobsRaw();
    return getUserJobDTOS(rawResults);
  }

  private List<UserJobDTO> getUserJobDTOS ( List<Object[]> rawResults ) {
    Map<UserModel, List<JobModel>> groupedResults = new HashMap<>();

    for (Object[] row : rawResults) {
      UserModel user = (UserModel) row[0];
      JobModel job = (JobModel) row[1];

      if (!groupedResults.containsKey(user)) {
        groupedResults.put(user, new ArrayList<>());
      }
      groupedResults.get(user).add(job);
    }

    List<UserJobDTO> userJobDTOs = new ArrayList<>();
    for (Map.Entry<UserModel, List<JobModel>> entry : groupedResults.entrySet()) {
      userJobDTOs.add(new UserJobDTO(entry.getKey(), entry.getValue()));
    }

    return userJobDTOs;
  }

  @Query("SELECT u, j FROM UserModel u JOIN UserJobModel uj ON uj.user = u JOIN JobModel j ON uj.job = j WHERE u.email = :email")
  List<Object[]> findAllWithJobsRawByEmail(@Param("email") String email);


}

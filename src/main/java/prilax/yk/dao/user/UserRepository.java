package prilax.yk.dao.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import prilax.yk.entity.user.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    @Query(value = "SELECT entity FROM User entity WHERE entity.mobileNo = :mobileNo")
    public Optional<User> findUsersByMobileNo( @Param("mobileNo") String mobileNo);

    @Query(value = "SELECT entity FROM User entity WHERE entity.email = :email")
    public Optional<User> findUserByEmail(@Param("email") String email);

    @Query(value = "SELECT entity FROM User entity WHERE entity.mobileNo = :mobileNo")
    public Optional<User> findUserByMobileNo(@Param("mobileNo") String mobileNo);

}

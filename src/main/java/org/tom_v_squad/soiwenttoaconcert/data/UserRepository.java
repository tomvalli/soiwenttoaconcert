package org.tom_v_squad.soiwenttoaconcert.data;

import org.springframework.data.repository.CrudRepository;
import org.tom_v_squad.soiwenttoaconcert.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}

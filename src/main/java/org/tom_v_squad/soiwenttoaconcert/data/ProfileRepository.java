package org.tom_v_squad.soiwenttoaconcert.data;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tom_v_squad.soiwenttoaconcert.controllers.ProfileController;
import org.tom_v_squad.soiwenttoaconcert.models.Profile;


@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

}

package org.tom_v_squad.soiwenttoaconcert.data;

import org.springframework.data.repository.CrudRepository;
import org.tom_v_squad.soiwenttoaconcert.models.Event;
import org.tom_v_squad.soiwenttoaconcert.models.Greeting;

public interface GreetingRepository extends CrudRepository<Greeting, Integer> {
}

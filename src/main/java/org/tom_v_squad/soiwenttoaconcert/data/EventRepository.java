package org.tom_v_squad.soiwenttoaconcert.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tom_v_squad.soiwenttoaconcert.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
}

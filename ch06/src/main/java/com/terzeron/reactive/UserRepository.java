package com.terzeron.reactive;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
    public Flux<User> findAllById(Integer id);
    public Mono<User> findFirstByFirstName(String name);
}

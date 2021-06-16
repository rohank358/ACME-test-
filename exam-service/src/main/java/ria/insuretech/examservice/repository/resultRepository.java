package ria.insuretech.examservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ria.insuretech.examservice.entity.user;

@Repository
public interface resultRepository extends MongoRepository<user, String> {

}

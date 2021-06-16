package ria.insuretech.examservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ria.insuretech.examservice.entity.model;

@Repository
public interface quesRepository extends MongoRepository<model, String> {

}

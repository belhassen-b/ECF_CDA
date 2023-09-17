package com.example.observation.repository;

import com.example.observation.entity.Observation;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.Document;

@Repository
public interface ObservationRepository extends MongoRepository<Observation,String> {

//    @Aggregation(pipeline = {
//            "{$match: { $or: [ { driverId: :#{#driverId} }, { clientId: :#{#clientId} } ] }}", "{$sort: { notation: 1 }}", "{$limit: 1}"
//    })
//    Observation searchByNotationMax(Long driverId, Long clientId);
//
//    @Aggregation(pipeline = {
//            "{$match: { $or: [ { driverId: :#{#driverId} }, { clientId: :#{#clientId} } ] }}",
//            "{$sort: { notation: -1 }}",
//            "{$limit: 1}"
//    })
//    Observation searchByNotationMin(@Param("driverId") Long driverId, @Param("clientId") Long clientId);
//
//    @Aggregation(pipeline = {"{$match: {$or: [ { idDriver: driverId }, { idClient: clientId } ]}}", "{ $group: { _id: null, averageNotation: { $avg: '$notation' }}}"})
//    Double searchByNotationMoyenne(@Param("driverId") Long driverId, @Param("clientId") Long clientId);
////db.observation.aggregate([{$match: {$or: [ { idDriver: 2 }, { idClient: 2 } ]}}, { $group: { _id: null, averageNotation: { $avg: '$notation' }}}]);
    Integer countObservationByIdDriverOrIdClient(Long driverId,Long clientId);

}

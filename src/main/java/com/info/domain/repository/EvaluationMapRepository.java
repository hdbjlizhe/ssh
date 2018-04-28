package com.info.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.info.domain.EvaluationMap;
import com.info.domain.entity.Duty;

@Repository
public interface EvaluationMapRepository extends JpaRepository<EvaluationMap, Integer> {

	@Query(value="FROM EvaluationMap e WHERE e.minScorer.weight=:weight OR e.maxScorer.weight=:weight")
	public List<EvaluationMap> findByScorer(@Param("weight") int weight);
	
	List<EvaluationMap> findByMaxScorer(Duty maxscorer);
	List<EvaluationMap> findByMinScorer(Duty minscorer);

}

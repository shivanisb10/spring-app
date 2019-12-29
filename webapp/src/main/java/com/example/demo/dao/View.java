package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Count;

@Repository
public interface View extends CrudRepository<Count, Integer> {

	@Modifying
	@Transactional
	@Query(value="update view set count=count+1",nativeQuery = true)
	public  int updatecount();
	
	@Query(value="select count from view",nativeQuery=true)
	public int getcount();
	
	@Modifying
	@Transactional
	@Query(value="insert into view(count) select 0 where not exists(select * from view)",nativeQuery =true)
	public int insert();
	
	@Modifying
	@Transactional
	@Query(value="create table if not exists view(count int)",nativeQuery =true)
	public int create();
}
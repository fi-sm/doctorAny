package com.doctoranywhere.app.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.doctoranywhere.app.model.PatientDetailModel;

@Repository
public interface PatientDetailRepository extends PagingAndSortingRepository<PatientDetailModel, Long> {

	
	Page<PatientDetailModel> findAllByDeleted(String deleted, Pageable pageable);
}

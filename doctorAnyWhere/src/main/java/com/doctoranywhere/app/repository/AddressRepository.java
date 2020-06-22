package com.doctoranywhere.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doctoranywhere.app.model.PatientAddressModel;

@Repository
public interface AddressRepository extends CrudRepository<PatientAddressModel, Long> {

	List<PatientAddressModel> findAllByPatientId(Long patientId);
	
}

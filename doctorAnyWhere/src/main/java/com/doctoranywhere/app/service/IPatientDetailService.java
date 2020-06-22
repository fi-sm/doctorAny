package com.doctoranywhere.app.service;

import com.doctoranywhere.app.bean.PatientDetailWrapper;
import com.doctoranywhere.app.model.PatientDetailModel;

public interface IPatientDetailService {
	
PatientDetailWrapper findPaginated(int pageNo, int pageSize);
public PatientDetailWrapper getAllActivePateintDetails(int pageNo, int pageSize,String isDeleted);

public void deleteById(Long id) ;
public PatientDetailModel addUpdate(PatientDetailModel  patientDetailModel);

}

package com.doctoranywhere.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.doctoranywhere.app.bean.PatientAddress;
import com.doctoranywhere.app.bean.PatientDetail;
import com.doctoranywhere.app.bean.PatientDetailWrapper;
import com.doctoranywhere.app.model.PatientAddressModel;
import com.doctoranywhere.app.model.PatientDetailModel;
import com.doctoranywhere.app.repository.AddressRepository;
import com.doctoranywhere.app.repository.PatientDetailRepository;


@Service
public class PatientDetailService implements IPatientDetailService {
	
    @Autowired
    private PatientDetailRepository patientDetailRepository;
    
    @Autowired
    private AddressRepository addressRepository;

	@Override
	public PatientDetailWrapper findPaginated(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<PatientDetailModel> pagedResult = patientDetailRepository.findAll(paging);
        
        
        List<PatientDetail> listResult=new ArrayList<PatientDetail>();
        List<PatientAddress> addresList=new ArrayList<PatientAddress>();
        
        
        PatientDetail patientDetail=null;
        PatientAddress patientAddress=null;
        for(PatientDetailModel model:pagedResult.getContent()) {
        	patientDetail=new PatientDetail();
        	patientDetail.setId(model.getId());
        	patientDetail.setPatientFirstname(model.getPatientFirstname());
        	patientDetail.setPatientLastName(model.getPatientLastName());
        	patientDetail.setContactNumber(model.getContactNumber());
        	listResult.add(patientDetail);
        	List< PatientAddressModel >addressList=addressRepository.findAllByPatientId(patientDetail.getId());
        	addresList=new ArrayList<PatientAddress>();
        	for(PatientAddressModel add:addressList) {
        		patientAddress=new PatientAddress();
        		
        		patientAddress.setId(add.getId());
        		patientAddress.setPatientId(add.getPatientId());
        		patientAddress.setAddressLine1(add.getAddressLine1());
        		patientAddress.setAddressLine2(add.getAddressLine2());
        		patientAddress.setCity(add.getCity());
        		patientAddress.setCounty(add.getCounty());
        		patientAddress.setPostalCode(add.getPostalCode());
        		addresList.add(patientAddress);
        	}
        	patientDetail.setAddressList(addresList);
        	
        }
        PatientDetailWrapper patientDetailWrapper=new PatientDetailWrapper();
        patientDetailWrapper.setData(listResult);
        patientDetailWrapper.setPage(pageNo);
        patientDetailWrapper.setPer_page(pageSize);
        patientDetailWrapper.setTotal(pagedResult.getTotalElements());
        patientDetailWrapper.setTotal_pages(pagedResult.getTotalPages());
        
        
        return patientDetailWrapper;
	}
	
	@Override
	public PatientDetailWrapper getAllActivePateintDetails(int pageNo, int pageSize,String isDeleted) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<PatientDetailModel> pagedResult = patientDetailRepository.findAllByDeleted(isDeleted,paging);
        
        List<PatientDetail> listResult=new ArrayList<PatientDetail>();
        List<PatientAddress> addresList=new ArrayList<PatientAddress>();
        
        
        PatientDetail patientDetail=null;
        PatientAddress patientAddress=null;
        for(PatientDetailModel model:pagedResult.getContent()) {
        	patientDetail=new PatientDetail();
        	patientDetail.setId(model.getId());
        	patientDetail.setPatientFirstname(model.getPatientFirstname());
        	patientDetail.setPatientLastName(model.getPatientLastName());
        	patientDetail.setContactNumber(model.getContactNumber());
        	listResult.add(patientDetail);
        	List< PatientAddressModel >addressList=addressRepository.findAllByPatientId(patientDetail.getId());
        	for(PatientAddressModel add:addressList) {
        		patientAddress=new PatientAddress();
        		
        		patientAddress.setId(add.getId());
        		patientAddress.setPatientId(add.getPatientId());
        		patientAddress.setAddressLine1(add.getAddressLine1());
        		patientAddress.setAddressLine2(add.getAddressLine2());
        		patientAddress.setCity(add.getCity());
        		patientAddress.setCounty(add.getCounty());
        		patientAddress.setPostalCode(add.getPostalCode());
        		addresList.add(patientAddress);
        	}
        	
        }
        PatientDetailWrapper patientDetailWrapper=new PatientDetailWrapper();
        patientDetailWrapper.setData(listResult);
        patientDetailWrapper.setPage(pageNo);
        patientDetailWrapper.setPer_page(pageSize);
        patientDetailWrapper.setTotal(pagedResult.getTotalElements());
        patientDetailWrapper.setTotal_pages(pagedResult.getTotalPages());
        
        
        return patientDetailWrapper;
	}
	
	

	
	public void deleteById(Long id) {

		patientDetailRepository.deleteById(id);
    }

	@Override
	public PatientDetailModel addUpdate(PatientDetailModel patientDetailModel) {
		// TODO Auto-generated method stub
		patientDetailModel = patientDetailRepository.save(patientDetailModel);
		return patientDetailModel;
	}
}

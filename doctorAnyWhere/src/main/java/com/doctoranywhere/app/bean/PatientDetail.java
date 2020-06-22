package com.doctoranywhere.app.bean;

import java.util.List;

public class PatientDetail {
	
	

	    private Long id;
	    
	    private String patientFirstname;
	  
		private String patientLastName;
	   
		private String contactNumber;
	   
	    private String deleted;
	    List<PatientAddress> addressList;
		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}
		/**
		 * @return the patientFirstname
		 */
		public String getPatientFirstname() {
			return patientFirstname;
		}
		/**
		 * @param patientFirstname the patientFirstname to set
		 */
		public void setPatientFirstname(String patientFirstname) {
			this.patientFirstname = patientFirstname;
		}
		/**
		 * @return the patientLastName
		 */
		public String getPatientLastName() {
			return patientLastName;
		}
		/**
		 * @param patientLastName the patientLastName to set
		 */
		public void setPatientLastName(String patientLastName) {
			this.patientLastName = patientLastName;
		}
		/**
		 * @return the contactNumber
		 */
		public String getContactNumber() {
			return contactNumber;
		}
		/**
		 * @param contactNumber the contactNumber to set
		 */
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		/**
		 * @return the deleted
		 */
		public String getDeleted() {
			return deleted;
		}
		/**
		 * @param deleted the deleted to set
		 */
		public void setDeleted(String deleted) {
			this.deleted = deleted;
		}
		/**
		 * @return the addressList
		 */
		public List<PatientAddress> getAddressList() {
			return addressList;
		}
		/**
		 * @param addressList the addressList to set
		 */
		public void setAddressList(List<PatientAddress> addressList) {
			this.addressList = addressList;
		}

}

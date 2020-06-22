package com.doctoranywhere.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_detail")
public class PatientDetailModel {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="fname")
    private String patientFirstname;
    @Column(name="lname")
	private String patientLastName;
    @Column(name="contact")
	private String contactNumber;
    @Column(name="deleted")
    private String deleted;
	
	public PatientDetailModel() {
		
	}

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

	@Override
	public String toString() {
		return "PatientDetailModel [id=" + id + ", patientFirstname=" + patientFirstname + ", patientLastName="
				+ patientLastName + ", contactNumber=" + contactNumber + "]";
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

}

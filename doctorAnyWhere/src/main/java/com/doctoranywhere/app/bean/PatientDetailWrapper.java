package com.doctoranywhere.app.bean;

import java.util.ArrayList;
import java.util.List;

import com.doctoranywhere.app.model.PatientDetailModel;

public class PatientDetailWrapper {
	
	
	private  Integer page;
	private  Integer per_page;
	private  Long total;
	private  Integer total_pages;
	private String message;
	private List<PatientDetail> data=new ArrayList<>();
	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}
	/**
	 * @return the per_page
	 */
	public Integer getPer_page() {
		return per_page;
	}
	/**
	 * @param per_page the per_page to set
	 */
	public void setPer_page(Integer per_page) {
		this.per_page = per_page;
	}
	
	/**
	 * @return the total_pages
	 */
	public Integer getTotal_pages() {
		return total_pages;
	}
	/**
	 * @param total_pages the total_pages to set
	 */
	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "PatientDetail [page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages="
				+ total_pages + ", message=" + message + ", data=" + data + "]";
	}
	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
	}
	/**
	 * @return the data
	 */
	public List<PatientDetail> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(List<PatientDetail> data) {
		this.data = data;
	}
	
   
}

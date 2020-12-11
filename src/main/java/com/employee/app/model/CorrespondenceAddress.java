package com.employee.app.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "correspondenceAddress")
public class CorrespondenceAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "housename")
    private String housename;
    @Column(name = "street")
    private String street;
    @Column(name = "postoffice")
    private String postoffice;
    @Column(name = "district")
    private String district;
//    @OneToOne(mappedBy="address")
//    private Employee emp;
//    
//    public Employee getEmp() {
//		return emp;
//	}
//
//	public void setEmp(Employee emp) {
//		this.emp = emp;
//	}

	public CorrespondenceAddress() {

    }

    public CorrespondenceAddress(String housename,String street,String postoffice,String district) {
        super();
        this.housename = housename;
        this.street = street;
        this.postoffice = postoffice;
        this.district = district;
        
    }
    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostoffice() {
		return postoffice;
	}

	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}
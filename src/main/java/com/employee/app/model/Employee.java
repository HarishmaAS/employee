package com.employee.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@Getter
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;
    
    @Column(name = "email", unique=true)
    private String email;
    
    @Column(name = "permanent_address")
    private String permanent_address;
    
    @Column(name = "status")
    private String status;

//    @OneToMany( mappedBy="address", fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ca_id", referencedColumnName = "id")
    List < CorrespondenceAddress > ca = new ArrayList < > ();

  

    public Employee(String first_name, String last_name,String email,String permanent_address,String status,List <CorrespondenceAddress> ca) {
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.permanent_address = permanent_address;
        this.status = status;
        this.ca=ca;
    }



    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPermanent_address() {
		return permanent_address;
	}

	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<CorrespondenceAddress> getCa() {
		return ca;
	}

	public void setCa(List<CorrespondenceAddress> ca) {
		this.ca = ca;
	}


	
}
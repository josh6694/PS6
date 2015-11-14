package domain;


import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import util.LocalDateAdapter;

public class PersonDomainModel {

	protected  UUID perID;
    protected  String firstName;
    protected  String lastName;
    protected  String street;
    protected  Integer postalCode;
    protected  String city;
    protected  Date birthday;

	public PersonDomainModel() {
		this.perID = UUID.randomUUID();
		this.postalCode = 0;
	}

    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street=street;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode=postalCode;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city=city;
    }


    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday= birthday;
    }

	public UUID getPerID() {
		return this.perID;
	}

	public void setPerID(UUID perID){
		perID=perID;
		
	}




}
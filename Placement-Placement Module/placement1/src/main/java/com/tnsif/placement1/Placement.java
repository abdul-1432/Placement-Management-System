package com.tnsif.placement1;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Placement {
	
	@Id
	private Long id;
	private String name;
	private Date date;
	private String qualification;
	private Integer year;
	
	public Placement() {

	}

	public Placement(Long id, String name, Date date, String qualification, Integer year) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.qualification = qualification;
		this.year = year;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQuali(String quali) {
		this.qualification = quali;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Placement [id=" + id + ", name=" + name + ", date=" + date + ", qualification=" + qualification + ", year=" + year + "]";
	}
	
}

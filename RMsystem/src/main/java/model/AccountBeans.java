package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class AccountBeans implements Serializable{
	private String id;
	private String division;
	private String name;
	private String kana;
	private String pass;
	private String address;
	private Integer age;
	private String classId;
	private Date admissionDate;
	private Date graduationDate;
	private Integer absentDay;
	private Date lastUpdated;
	
	public String getId() {
		return id; 
	}
	public void setId(String id) {
		this.id = id; 
	}
	
	public String getDivision() {
		return division; 
	}
	public void setDivision(String division) {
		this.division = division;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getKana() {
		return kana;
	}
	public void setKana(String kana) {
		this.kana = kana;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	public Date getAdmissionDate() {
		 if (admissionDate == null) {
		        return new Date(0); // 1970-01-01 00:00:00 のような適切なデフォルト値を設定する
		 }
		return admissionDate;
	}
	
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	
	
	public Date getGraduationDate() {
		if (graduationDate == null) {
			return new Date(0);
		}
		return graduationDate;
	}
	
	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}
	
	public Integer getAbsentDay() {
	    return absentDay;
	}
	
	public void setAbsentDay(Integer absentDay) {
	    this.absentDay = absentDay;
	}

	public Date getLastUpdated() {
	    return lastUpdated;
	}
	
	public void setLastUpdateed(Date lastUpdateed) {
	    this.lastUpdated = lastUpdateed;
	}
	public void setLastUpdated(Timestamp timestamp) {
		// TODO 自動生成されたメソッド・スタブ
		
	}


}

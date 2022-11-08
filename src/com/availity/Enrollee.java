package com.availity;

import java.util.Objects;

public class Enrollee {

	private String userId;
	private String firstName;
	private String LastName;
	private String version;
	private String InsuranceCompany;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getInsuranceCompany() {
		return InsuranceCompany;
	}
	public void setInsuranceCompany(String insuranceCompany) {
		InsuranceCompany = insuranceCompany;
	}
	@Override
	public int hashCode() {
		return Objects.hash(InsuranceCompany, LastName, firstName, userId, version);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enrollee other = (Enrollee) obj;
		return Objects.equals(InsuranceCompany, other.InsuranceCompany) && Objects.equals(LastName, other.LastName)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(userId, other.userId)
				&& Objects.equals(version, other.version);
	}
}

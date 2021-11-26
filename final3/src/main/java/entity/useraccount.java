package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useraccount")
public class useraccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uID")
	private int uID;
	@Column(name="uName")
	private String uName;
	@Column(name="uPass")
	private String uPass;
	@Column(name="isSeller")
	private int isSeller;
	@Column(name="isAdmin")
	private int isAdmin;
	

	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPass() {
		return uPass;
	}
	public void setuPass(String uPass) {
		this.uPass = uPass;
	}
	public int getIsSeller() {
		return isSeller;
	}
	public void setIsSeller(int isSeller) {
		this.isSeller = isSeller;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}

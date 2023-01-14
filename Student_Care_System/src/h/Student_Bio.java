package h;

public class Student_Bio {
private String name,Id,Phone_Number,eMail,Password;

public Student_Bio(String name, String id, String phone_Number, String eMail, String password) {
	
	this.name = name;
	this.Id = id;
	this.Phone_Number = phone_Number;
	this.eMail = eMail;
	this.Password = password;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
}

public String getPhone_Number() {
	return Phone_Number;
}

public void setPhone_Number(String phone_Number) {
	Phone_Number = phone_Number;
}

public String geteMail() {
	return eMail;
}

public void seteMail(String eMail) {
	this.eMail = eMail;
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}


}

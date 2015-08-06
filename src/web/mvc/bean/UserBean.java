package web.mvc.bean;

public class UserBean {

	private String login_id;
	private String pwd;
	private String name;
	private String sex;
	private String location;
	private String phone;
	private String email;
	private String user_right;
	private String is_used;

	public UserBean() {
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_right() {
		return user_right;
	}

	public void setUser_right(String user_right) {
		this.user_right = user_right;
	}
	
	public String getIs_used(){
		return is_used;
	}
	
	public void setIs_used(String is_used){
		this.is_used = is_used;
	}

}

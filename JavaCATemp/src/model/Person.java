package model;

public class Person {
	private String id;
	private String name;
	private String email;
	private String pw;
	private String login;
	private String role;
	private int loadTime;
	private String selNav;
	
	public String getSelNav() {
		return selNav;
	}

	public void setSelNav(String selNav) {
		this.selNav = selNav;
	}

	public int getLoadTime() {
		return loadTime;
	}

	public void setLoadTime(int loadTime) {
		this.loadTime = loadTime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String id, String name, String email, String pw, String login) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pw = pw;
		this.login = login;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", pw=" + pw + ", login=" + login + "]";
	}





}

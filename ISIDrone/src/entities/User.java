package entities;

public class User {
	int id;
	String lastName,
		firstName,
		email,
		password;
	Address shipAddress;
        int userRole;
	
	public User() {}
	
    public User(int id, String lastName, String firstName, String email, String password, Address shipAddress, int userRole) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.shipAddress = shipAddress;
        this.userRole = userRole;
    }

    public User(int id, String lastName, String firstName, String email, int userRole) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.userRole = userRole;
    }


    

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}

	public Address getShipAddress() {
		return shipAddress;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setShipAdress(Address adress) {
		this.shipAddress = adress;
	}
}

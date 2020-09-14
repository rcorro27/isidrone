package entities;

import util.Const;

public class Item {

    // Attribut
    private int id,
            category,
            stock,
            rating,
            activer,
            nbReview;

    

<<<<<<< HEAD
    
   
	private String name,
		description,
		serial,
		image,
		brand;
	
	private double price;
	private boolean isActive;
	
	// Constructeur
	public Item() {
	}
	
	public Item(int id, int category, String name,
			String description ,double price, String serial, String image,
			int stock, boolean isActive) {
		this.id = id;
		this.category = category;
		this.stock = stock;
		this.name = name;
		this.description = description;
		this.serial = serial;
		this.image = image;
		this.price = price;
		this.isActive = isActive;
	}

    public Item(int id, int category, int stock, int rating, int activer, int nbReview, String name, String description, String serial, String image, String brand, double price) {
        this.id = id;
        this.category = category;
        this.stock = stock;
        this.rating = rating;
        this.activer = activer;
        this.nbReview = nbReview;
        this.name = name;
        this.description = description;
        this.serial = serial;
        this.image = image;
        this.brand = brand;
        this.price = price;
    }
	
	// Special getter
	public String getImgAndPath(){
		return Const.ISIDRONE_HOME + image;
	}
	
	//Getters
	public int getId() {
		return id;
	}

	public int getCategory() {
		return category;
	}

	public int getStock() {
		return stock;
	}

	public int getRating() {
		return rating;
	}

	public int getNbReview() {
		return nbReview;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getSerial() {
		return serial;
	}

	public String getImage() {
		return image;
	}

	public String getBrand() {
		return brand;
	}

	public double getPrice() {
		return price;
	}

	public boolean isActive() {
		return isActive;
	}
        public int getActiver() {
        return activer;
    }

	public void setId(int id) {
		this.id = id;
	}

	//Setters
	public void setCategory(int category) {
		this.category = category;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setNbReview(int nbReview) {
		this.nbReview = nbReview;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
        public void setActiver(int activer) {
        this.activer = activer;
    }

=======
    private String name,
            description,
            serial,
            image,
            brand;

    private double price;
    private boolean isActive;

    // Constructeur
    public Item() {
    }

    public Item(int id, int category, String name,
            String description, double price, String serial, String image,
            int stock, boolean isActive) {
        this.id = id;
        this.category = category;
        this.stock = stock;
        this.name = name;
        this.description = description;
        this.serial = serial;
        this.image = image;
        this.price = price;
        this.isActive = isActive;
    }

    public Item(int category, int stock, String name, String description, String serial, String image, double price, int activer) {
        this.category = category;
        this.stock = stock;
        this.name = name;
        this.description = description;
        this.serial = serial;
        this.image = image;
        this.price = price;
        this.activer = activer;
    }

    // Special getter
    public String getImgAndPath() {
        return Const.ISIDRONE_HOME + image;
    }

    //Getters
    public int getId() {
        return id;
    }

    public int getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public int getRating() {
        return rating;
    }

    public int getNbReview() {
        return nbReview;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSerial() {
        return serial;
    }

    public String getImage() {
        return image;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Setters
    public void setCategory(int category) {
        this.category = category;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setNbReview(int nbReview) {
        this.nbReview = nbReview;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
>>>>>>> cc1bdac5923c98fa3db8539b420fd91af25d25bd
}

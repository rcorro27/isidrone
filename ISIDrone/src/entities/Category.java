package entities;

public class Category {
	private int id;
	private String name,
		description;
        private boolean isActive;
	
	public Category() {}
	
	public Category(int id, String name, String description, boolean isActive) {
		this.id = id;
		this.name = name;
		this.description = description;
                this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

        public boolean isIsActive() {
            return isActive;
        }

        public void setIsActive(boolean isActive) {
            this.isActive = isActive;
        }
        
        
}

//fvcproductions
//how to pass by reference

class Dog {
	
	private String name;

	public Dog(String name) {
		
		this.name = name;
	
	}

	public String getName() {
		
		return name;
	
	}

	static void woah(Dog d) {
		
		d = new Dog("nefer");
	
	}

	public static void main(String args[]) {
		
		Dog d = new Dog("diamond");
		woah(d);
		System.out.println(d.getName());
	
	}

}

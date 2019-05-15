package principal;

class Principal{
	public static void main(String[] args) {
		Menu menu = new Menu();		
		try {
			menu.ejecutar();			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
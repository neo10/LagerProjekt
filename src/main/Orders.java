package main;

public class Orders {
	private final String[][] data = {
			{"1","Einlagerung","Papier","Weiss","A4","200"},
			{"2","Einlagerung","Papier","Blau","A5","300"},
			{"3","Einlagerung","Holz","Kiefer","Bretter","200"},
			{"4","Einlagerung","Holz","Buche","Balken","500"},
			{"5","Einlagerung","Holz","Eiche","Scheit","200"},
			{"6","Einlagerung","Papier","Blau","A5","200"},
			{"7","Einlagerung","Papier","Blau","A5","200"},
			{"8","Einlagerung","Stein","Marmor","Mittel","400"},
			{"9","Einlagerung","Stein","Granit","Schwer","500"},
			{"10","Einlagerung","Stein","Sandstein","Leicht","200"},
			{"11","Auslagerung","Papier","Blau","A5","1000"},
			{"12","Auslagerung","Holz","Eiche","Scheit","1200"},
			{"13","Auslagerung","Stein","Marmor","Mittel","1000"},
			{"14","Auslagerung","Papier","Weiss","A5","1500"},
			{"15","Einlagerung","Holz","Eiche","Balken","400"},
			{"16","Einlagerung","Holz","Eiche","Scheit","600"},
			{"17","Einlagerung","Holz","Buche","Scheit","200"},
			{"18","Einlagerung","Stein","Granit","Leicht","400"},
			{"19","Einlagerung","Papier","Blau","A3","200"},
			{"20","Einlagerung","Papier","Blau","A5","200"},
			{"21","Einlagerung","Holz","Eiche","Scheit","600"},
			{"22","Einlagerung","Holz","Buche","Balken","600"},
			{"23","Einlagerung","Stein","Sandstein","Schwer","200"},
			{"24","Einlagerung","Stein","Granit","Schwer","600"},
			{"25","Einlagerung","Holz","Buche","Bretter","400"},
			{"26","Einlagerung","Holz","Buche","Scheit","200"},
			{"27","Auslagerung","Holz","Buche","Scheit","1000"},
			{"28","Auslagerung","Papier","Blau","A5","1200"},
			{"29","Auslagerung","Stein","Granit","Schwer","1500"},
			{"30","Auslagerung","Holz","Buche","Balken","1000"},
			{"31","Auslagerung","Stein","Sandstein","Schwer","1300"},
			{"32","Einlagerung","Stein","Granit","Schwer","400"},
			{"33","Einlagerung","Stein","Marmor","Mittel","600"},
			{"34","Einlagerung","Stein","Granit","Leicht","400"},
			{"35","Einlagerung","Stein","Granit","Leicht","400"},
			{"36","Einlagerung","Papier","Weiss","A4","400"},
			{"37","Einlagerung","Stein","Granit","Leicht","400"},
			{"38","Einlagerung","Holz","Buche","Bretter","600"},
			{"39","Einlagerung","Holz","Kiefer","Bretter","600"},
			{"40","Einlagerung","Stein","Sandstein","Leicht","400"},
			{"41","Auslagerung","Papier","Weiss","A4","1000"},
			{"42","Auslagerung","Stein","Marmor","Mittel","1200"},
			{"43","Auslagerung","Holz","Buche","Bretter","1100"},
			{"44","Auslagerung","Papier","Weiss","A4","1500"},
			{"45","Auslagerung","Holz","Kiefer","Bretter","1000"},
			{"46","Auslagerung","Stein","Sandstein","Leicht","1200"},
			{"47","Auslagerung","Holz","Kiefer","Bretter","1100"},
			{"48","Einlagerung","Papier","Gruen","A4","400"}
		};
	private int lastOrder = -1;
	
	public String[] getNextOrder() {
		lastOrder++;
		return data[lastOrder];
	}
	
/*	public static void main(String[] args) {
		// just for testing purpose
		Orders orders = new Orders();
		String[] order = orders.getNextOrder();
		for(String cell: order) {
			System.out.print(cell);
			System.out.print(";");
		}
		System.out.println(); // new line
		order = orders.getNextOrder();
		for(String cell: order) {
			System.out.print(cell);
			System.out.print(";");
		}
	}*/
}

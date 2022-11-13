package AE1;

import java.util.Scanner;

public class RobotDispensador {
	public static Scanner scan = new Scanner(System.in);
	//public static String txtbusqueda;
	
	public static Medicaments[] Farmacs = new Medicaments[20];
	public static Carrito[] Carr = new Carrito[20];
	public static int num_prodCarr = 0;
	//dones valor als medicaments
	public static void val_medicaments() {
		Farmacs[0] = new Medicaments(1, "Faiser", "Paracetamol", 0.60, 20);
		Farmacs[1] = new Medicaments(2, "Pfizer", "Paracetamol", 0.60, 15);
		Farmacs[2] = new Medicaments(3, "Roche Group", "Ibuprofeno", 4.56, 20);
		Farmacs[3] = new Medicaments(4, "Merck", "Kaopectate", 4.50, 100);//diarrea leve
		Farmacs[4] = new Medicaments(5, "Amgen", "Pepto-Bismol", 70, 20);//diarrea leve
		Farmacs[5] = new Medicaments(6, "Faiser", "Enfalyte", 4.50, 20);//diarrea grave
		Farmacs[6] = new Medicaments(7, "Faiser", "Pedialyte", 3.75, 17);//diarrea grave
		Farmacs[7] = new Medicaments(8, "Faiser", "Cortaid", 6.41, 20);//ERUPCIONES CUTÁNEAS Y PICAZÓN 
		Farmacs[8] = new Medicaments(9, "Roche Group", "Cortizone 10", 4.79, 20);//ERUPCIONES CUTÁNEAS Y PICAZÓN 
		Farmacs[9] = new Medicaments(10, "Roche Group", "Nistatina", 3.12, 10);//ERUPCIONES CUTÁNEAS Y PICAZÓN
		Farmacs[10] = new Medicaments(11, "Roche Group", "Miconazol", 23.00, 100);//ERUPCIONES CUTÁNEAS Y PICAZÓN
		Farmacs[11] = new Medicaments(12, "Roche Group", "Clotrimazol", 9.41, 20);//ERUPCIONES CUTÁNEAS Y PICAZÓN
		Farmacs[12] = new Medicaments(13, "Pfizer", "HIDROXIZINA", 2.97, 20);
		Farmacs[13] = new Medicaments(14, "Pfizer", "Fluoxetine", 5.25, 100);//depresion
		Farmacs[14] = new Medicaments(15, "Pfizer", "Citalopram", 10.24, 50);//depresion
		Farmacs[15] = new Medicaments(16, "Pfizer", "Sertralina", 11.66, 40);//depresion
		Farmacs[16] = new Medicaments(17, "Merck", "Paroxetine", 12.18, 60);//depresion
		Farmacs[17] = new Medicaments(18, "Merck", "Escitalopram", 17.48, 80);//depresion
		Farmacs[18] = new Medicaments(19, "Amgen", "Alprazolam ALTER", 4.84, 20);//ansiedad
		Farmacs[19] = new Medicaments(20, "Amgen", "Diazepam STADA", 1.92, 100);//ansiedad
	}
	
	public static void ini_Car() {
		for (int i = 0; i < Carr.length; i++) {
			Carr[i] = new Carrito(0, null, null, 0, 0);
		}
	}
	
	public static void vuidar_Carr() {
		num_prodCarr = 0;
		double resta = 0;
		boolean bol = false;
		for (int i = 0; i < Carr.length; i++) {
			for (int j = 0; j < Farmacs.length; j++) {
				if (Carr[i].getCn() == Farmacs[j].getCn()) {
				if (Carr[i].getUni() <= Farmacs[j].getUnitats()) {
					Farmacs[j].setUnitats(Farmacs[j].getUnitats() - Carr[i].getUni());
					System.out.println("Ara queden " + Farmacs[j].getUnitats() + " unitats al magatzem.");
					bol = true;
					break;
				}
				else
				{
					System.out.println("no hi ha suficients unitats d'aquest medicament.");
					bol = true;
				}
				}
			}
		
		}
		//Actualitzar alvara restar quanti comprades
	}
	public static void Menu1()
	{
		System.out.println("1. Conectar com a client");
		System.out.println("2. Conectar como administrador");
		System.out.println("3. Sortir");
	}
	
	public static void Menu2()
	{
		System.out.println("1. Buscar producte");
		System.out.println("2. Veure el carro de la compra");
		System.out.println("3. Pagar");
		System.out.println("4. Sortir");
	}
	
	public static void Menu3()
	{
		System.out.println("1. Actualitzar l'albarà");
		System.out.println("2. Sortir");
	}
	
	public static void P21()
	{
		System.out.println("Introdueix el nom, la categoría, marca i/o identificador del producte ...");
		String nomMedi = scan.nextLine();
		P211(nomMedi);
	}
	
	public static void P211(String nomMedi)
	{
		boolean bol = false;
		boolean guard = false;
		
		System.out.println("S'han trobat els seguents productes buscant a partir de " + nomMedi);
		System.out.println("<CN. Medicament - Marca - Nom - Preu - Unitats>");
		for (int i = 0; i < Farmacs.length; i++) {
			if (nomMedi.equalsIgnoreCase(Farmacs[i].getMarca()) || nomMedi.equalsIgnoreCase(Farmacs[i].getNom()))
			{
				System.out.println(Farmacs[i].getCn() + " | " + Farmacs[i].getMarca() + " | " + Farmacs[i].getNom() + " | " + Farmacs[i].getPreu() + " | " + Farmacs[i].getUnitats());
				bol = true;
			}
		}
		if(bol != true)
		{
			System.out.println("No s'ha trobat el medicament");
		}
		if( bol == true) {
			System.out.println("Diguem el cn del medicament que vols guardar:");
			int select = scan.nextInt();
			System.out.println("Quantes unitats vols del medicament amb cn " + select + "?");
			int unitats = scan.nextInt();
			guard = true;
			
			for (int i = 0; i < Farmacs.length; i++) {
				Carr[num_prodCarr] = new Carrito();
				if (select == Farmacs[i].getCn()) {
					Carr[num_prodCarr].setCn(Farmacs[i].getCn());
					Carr[num_prodCarr].setMarca(Farmacs[i].getMarca());
					Carr[num_prodCarr].setNom(Farmacs[i].getNom());
					Carr[num_prodCarr].setUni(unitats);
					Carr[num_prodCarr].setPreu(Farmacs[i].getPreu());
					num_prodCarr++;
					break;
				}
			}
		}
		if (!guard)
			System.out.println("No s'ha pogut guardar el medicament");
			guard = false;
	}
	
	public static void P22()
	{
		double 		suma = 0;
		int 		opcionMenu = 0;
		boolean		bol = false;
	
		System.out.println("1. Medicaments selecionats");
		System.out.println("2. Calcular el preu total dels medicaments selecionats");
		System.out.println("3. Sortir");
		opcionMenu = scan.nextInt();
		do {
			switch (opcionMenu) {
			case 1:
				if (num_prodCarr == 0)
				{
					System.out.println("El carrito està buit, ves a Buscar producte.");
					bol = true;
				}
				else
				{
					System.out.println("<CN. Medicament - Marca - Nom - Preu>");
					for (int i = 0; i < num_prodCarr; i++) {
						System.out.println(Carr[i].getMarca() + " - " +  Carr[i].getNom() + " - " + Carr[i].getUni() + " - " + Carr[i].getPreu() + " €");
						bol = true;
					}
				}
				break;
			case 2:
				if (num_prodCarr == 0)
				{
					System.out.println("El carrito està buit, ves a Buscar producte.");
					bol = true;
				}
				else
				{
				for (int i = 0; i < num_prodCarr; i++) {//l ai recorre el carrito que amb num_prodCarr ja has guardat els medicaments
					suma = (Carr[i].getPreu()*Carr[i].getUni())+ suma;
				}
				System.out.println("TOTAL: " + suma + " €");
				bol = true;
				}
				break;
			case 3:
				System.out.println("Surtint...");
				bol = true;
				break;
			default:
	        	System.out.println("Opció incorrecta");
	        	bol = true;
	        	break;
			}
		}while(bol == false);
	}
	
	public static void P31()
	{
		String nomMedi2 = "";
		System.out.println("Introdueix el nom, la categoría, marca i/o identificador del producte ...");
		nomMedi2 = scan.nextLine();
		P311(nomMedi2);
	}

	public static void P311(String nomMedi2)
	{
		boolean bol = false;
		boolean guard = false;
		System.out.println("S'han trobat els seguents productes buscant a partir de " + nomMedi2);
		System.out.println("<CN. Medicament - Marca - Nom - Preu - Unitats>");
		for (int i = 0; i < Farmacs.length; i++) {
			if (nomMedi2.equalsIgnoreCase(Farmacs[i].getMarca()) || nomMedi2.equalsIgnoreCase(Farmacs[i].getNom()))
			{
				System.out.println(Farmacs[i].getCn() + " | " + Farmacs[i].getMarca() + " | " + Farmacs[i].getNom() + " | " + Farmacs[i].getPreu() + " | " + Farmacs[i].getUnitats());
				bol = true;
			}
		}
		if(bol != true)
		{
			System.out.println("No s'ha trobat el medicament");
			P31();
		}
		if(bol == true) {
			System.out.println("Diguem el cn del medicament que vols guardar:");
			int select = scan.nextInt();
			System.out.println("Quantes unitats vols del medicament amb cn " + select + "?");
			int unitats = scan.nextInt();
			scan.nextLine();
			guard = true;
			
			for (int i = 0; i < Farmacs.length; i++) {
				Farmacs[i] = new Medicaments(Farmacs[i].getCn(), Farmacs[i].getMarca(), Farmacs[i].getNom(), Farmacs[i].getPreu(), unitats);
				if (select == Farmacs[i].getCn()) {
					Farmacs[i].setUnitats(unitats);
					break;
				}
			}
		}
	}
}


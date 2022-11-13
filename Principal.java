package AE1;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		RobotDispensador.val_medicaments();
		boolean bol = false;
		RobotDispensador.ini_Car();
		do {
			System.out.println("Escull l'opció 1, 2 o 3.");
			RobotDispensador.Menu1();
			int m1 = scan.nextInt();
			
			switch(m1)
			{
			case 1:
				do {
				System.out.println("Escull l'opció 1, 2, 3 o 4.");
				RobotDispensador.Menu2();
				int m2 = scan.nextInt();
				
				switch(m2)
				{
				case 1:
					RobotDispensador.P21();//Pantalla 2.1
					//Pantalla 2.1.1
					
					bol = true;
					break;
				case 2:
					RobotDispensador.P22();//Pantalla 2.2
					bol = true;
					break;
				case 3:
					RobotDispensador.vuidar_Carr();
					System.out.println("Ja s'ha efectuat el pagament.\nRecull els teus productes.");
					//torna al menu 2
					bol = true;
					break;
				case 4:
					System.out.println("Sortint...");
					bol = false;
					break;
				default:
					System.out.println("Aquesta opció no és valida, torna a escollir una opció.");
					bol = true;
				}
				} while(bol == true);
				break;
			case 2:
				do {
				System.out.println("Escull l'opció 1 o 2.");
				RobotDispensador.Menu3();
				int m3 = scan.nextInt();
				scan.nextLine();
				switch(m3)
				{
				case 1:
					RobotDispensador.P31();//Pantalla 3.1
					//Pantalla 3.1.1
					bol = true;
					break;
				case 2:
					bol = false;
				}
				} while (bol == true);
				break;
			case 3:
				System.out.println("Sortint...");
				bol = false;
				break;
			default:
				System.out.println("Aquesta opció no és valida, torna a escollir una opció.");
				bol = true;
			}
		}while(bol == true);
	}
	
	
}

package deneme;

import java.math.BigDecimal;
import java.util.Scanner;

public class AtmSimulater {
	 Scanner scanner = new Scanner(System.in);
     int choice = 0;
     static int amount=0;
	private Atm atm = new Atm();
	
	public void simulate() throws WithdrawFailException {
		init();
       operations();
	}

	private void operations() throws WithdrawFailException {
		 while (choice != 6) {
	            System.out.println("\n*** *** ***\n" + "\n �slem seciniz:"
	                    + "\n para �ekimi i�in 1'i tu�lay�n�z."
	                    + "\n kalan banknotlar� g�rmek i�in 2'yi tu�lay�n�z"
	                    + "\n ��k�� yapmak i�in 3'yi tu�lay�n�z"
	                    + "\n*** *** ***\n");
	            System.out.println("Se�inizi giriniz:");
	            choice = scanner.nextInt();
	            switch (choice) {
	                case 1:
	                 System.out.println("L�tfen �ekmek istedi�niz miktar� giriniz.");
	                 amount=scanner.nextInt();
	                 atm.withDrawMoney(new BigDecimal(amount));
	                    break;
	                case 2:
	                	System.out.println("Kalan banknotlar�n�z:");
	                	System.out.println("200'l�k banknotlar:"+atm.getTwoHundredTLList().size());
	                	System.out.println("100'l�k banknotlar:"+atm.getHundredTLList().size());
	                	System.out.println("50'l�k banknotlar:"+atm.getFiftyTLList().size());
	                	System.out.println("20'l�k banknotlar:"+atm.getTwentyTLList().size());
	                	System.out.println("10'l�k banknotlar:"+atm.getTenTLList().size());
	                	System.out.println("5'l�k banknotlar:"+atm.getFiveTLList().size());
	                case 3:
	                   System.out.println("��k�� yap�yorsunuz..");
	                    break;
	             
	                default:
	                    System.out.println("Hatal� tu�lama..");  
	            }
		 }
	            	
	}


	private void init() {
		for(int i=0; i<10; i++)
		{
			atm.getTwoHundredTLList().add(new Banknote(new BigDecimal(200)));
			atm.getHundredTLList().add(new Banknote(new BigDecimal(100)));
			atm.getFiftyTLList().add(new Banknote(new BigDecimal(50)));
			atm.getTwentyTLList().add(new Banknote(new BigDecimal(20)));
			atm.getTenTLList().add(new Banknote(new BigDecimal(10)));
			atm.getFiveTLList().add(new Banknote(new BigDecimal(5)));
		}
		
	}

}
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
	            System.out.println("\n*** *** ***\n" + "\n Ýslem seciniz:"
	                    + "\n para çekimi için 1'i tuþlayýnýz."
	                    + "\n kalan banknotlarý görmek için 2'yi tuþlayýnýz"
	                    + "\n çýkýþ yapmak için 3'yi tuþlayýnýz"
	                    + "\n*** *** ***\n");
	            System.out.println("Seçinizi giriniz:");
	            choice = scanner.nextInt();
	            switch (choice) {
	                case 1:
	                 System.out.println("Lütfen çekmek istediðniz miktarý giriniz.");
	                 amount=scanner.nextInt();
	                 atm.withDrawMoney(new BigDecimal(amount));
	                    break;
	                case 2:
	                	System.out.println("Kalan banknotlarýnýz:");
	                	System.out.println("200'lük banknotlar:"+atm.getTwoHundredTLList().size());
	                	System.out.println("100'lük banknotlar:"+atm.getHundredTLList().size());
	                	System.out.println("50'lük banknotlar:"+atm.getFiftyTLList().size());
	                	System.out.println("20'lük banknotlar:"+atm.getTwentyTLList().size());
	                	System.out.println("10'lük banknotlar:"+atm.getTenTLList().size());
	                	System.out.println("5'lük banknotlar:"+atm.getFiveTLList().size());
	                case 3:
	                   System.out.println("Çýkýþ yapýyorsunuz..");
	                    break;
	             
	                default:
	                    System.out.println("Hatalý tuþlama..");  
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
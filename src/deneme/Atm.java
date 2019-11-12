package deneme;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Iterator; 




public class Atm {

	private static final BigDecimal MINIMUM_BANKNOTE = new BigDecimal(5);

	private List<Banknote> fiveTLList = new ArrayList<Banknote>();
	private List<Banknote> tenTLList = new ArrayList<Banknote>();
	private List<Banknote> twentyTLList = new ArrayList<Banknote>();
	private List<Banknote> fiftyTLList = new ArrayList<Banknote>();
	private List<Banknote> hundredTLList = new ArrayList<Banknote>();
	private List<Banknote> twoHundredTLList = new ArrayList<Banknote>();

	public BigDecimal withDrawMoney(BigDecimal amount) throws WithdrawFailException {

		validateAmount(amount);

		WithdrawAvailableBanknotes withdrawAvailableBanknotes = checkAvailableBanknoteCounts(amount);
		
		final BigDecimal availabletotalAmount = checkAvailableTotalAmount(withdrawAvailableBanknotes, amount);

		if(availabletotalAmount.compareTo(amount) == 0) {
			
			removeBanknotes(withdrawAvailableBanknotes);
			
			return availabletotalAmount;
		}
				throw new WithdrawFailException("Avalable amount is: " + availabletotalAmount);
	}
	
	private void removeBanknotes(WithdrawAvailableBanknotes withdrawAvailableBanknotes) {
		removeBanknoteFromList(twoHundredTLList,withdrawAvailableBanknotes.getAvailabel200Count());
		removeBanknoteFromList(hundredTLList,withdrawAvailableBanknotes.getAvailabel100Count());
		removeBanknoteFromList(fiftyTLList,withdrawAvailableBanknotes.getAvailabel50Count());
		removeBanknoteFromList(twentyTLList,withdrawAvailableBanknotes.getAvailabel20Count());
		removeBanknoteFromList(tenTLList,withdrawAvailableBanknotes.getAvailabel10Count());
		removeBanknoteFromList(fiveTLList,withdrawAvailableBanknotes.getAvailabel5Count());
	}
	
	private void removeBanknoteFromList(List<Banknote> banknoteList, int count) {
		if(count > 0 ) {
			 
			//  Iterator itr = banknoteList.iterator(); 
				 
	          for(int i=0; i<count; i++)
	        	  banknoteList.remove(i);    
		}
		}
	

	private BigDecimal  checkAvailableTotalAmount(WithdrawAvailableBanknotes withdrawAvailableBanknotes,
			BigDecimal amount) {
		BigDecimal result, result1, result2, result3, result4;
		
		BigDecimal totalAmount =//new BigDecimal(10); 
				new BigDecimal(200).multiply(new BigDecimal(withdrawAvailableBanknotes.getAvailabel200Count()));
	//totalAmount.add(new BigDecimal(10));
		result=totalAmount.add(new BigDecimal(100).multiply(new BigDecimal(withdrawAvailableBanknotes.getAvailabel100Count())));
		result1=result.add(new BigDecimal(50).multiply(new BigDecimal(withdrawAvailableBanknotes.getAvailabel50Count())));
	result2=result1.add(new BigDecimal(20).multiply(new BigDecimal(withdrawAvailableBanknotes.getAvailabel20Count())));
		result3=result2.add(new BigDecimal(10).multiply(new BigDecimal(withdrawAvailableBanknotes.getAvailabel10Count())));
		result4=result3.add(new BigDecimal(5).multiply(new BigDecimal(withdrawAvailableBanknotes.getAvailabel5Count())));
		System.out.println("Total para: "+result4);
		return result4;	
	}

	private WithdrawAvailableBanknotes checkAvailableBanknoteCounts(BigDecimal amount) {

		final int available200Count = checkBanknote(twoHundredTLList, new BigDecimal(200), amount);

		BigDecimal remainderAmount = amount.subtract(new BigDecimal(200).multiply(new BigDecimal(available200Count)));


		final int available100Count = checkBanknote(hundredTLList, new BigDecimal(100), remainderAmount);
		

		remainderAmount = remainderAmount.subtract(new BigDecimal(100).multiply(new BigDecimal(available100Count)));
		
		final  int available50Count = checkBanknote(fiftyTLList, new BigDecimal(50), remainderAmount);

		remainderAmount = remainderAmount.subtract(new BigDecimal(50).multiply(new BigDecimal(available50Count)));

		final  int available20Count = checkBanknote(twentyTLList, new BigDecimal(20), remainderAmount);

		remainderAmount = remainderAmount.subtract(new BigDecimal(20).multiply(new BigDecimal(available20Count)));

		final int available10Count = checkBanknote(tenTLList, new BigDecimal(10), remainderAmount);

		remainderAmount = remainderAmount.subtract(new BigDecimal(10).multiply(new BigDecimal(available10Count)));

		final int available5Count = checkBanknote(fiveTLList, new BigDecimal(5), remainderAmount);

		remainderAmount = remainderAmount.subtract(new BigDecimal(5).multiply(new BigDecimal(available5Count)));

		final WithdrawAvailableBanknotes withdrawAvailableBanknotes = new WithdrawAvailableBanknotes(available200Count,
				available100Count, available50Count, available20Count, available10Count, available5Count);

		return withdrawAvailableBanknotes;
	}

	private int checkBanknote(List<Banknote> banknoteList, BigDecimal banknoteValue, BigDecimal amount) {

		if (banknoteList.size() == 0) {
			return 0;
		}

		if (amount.intValue() == 0) {
			return 0;
		}

		int banknoteCount = amount.intValue() / banknoteValue.intValue();

		if (banknoteCount > banknoteList.size()) {
			return banknoteList.size();
		}

		return banknoteCount;
	}

	private Boolean validateAmount(BigDecimal amount) throws WithdrawFailException {

		if (Objects.isNull(amount)) {
			throw new WithdrawFailException(WithdrawFailException.UNACCEPTABLE_AMOUNT);
		}

		if (BigDecimal.ZERO.compareTo(amount) >= 0) {
			throw new WithdrawFailException(WithdrawFailException.UNACCEPTABLE_AMOUNT);
		}

		if (amount.remainder(MINIMUM_BANKNOTE).compareTo(BigDecimal.ZERO) != 0) {
			throw new WithdrawFailException(WithdrawFailException.UNACCEPTABLE_FOR_PRODUCT);
		}

		return Boolean.TRUE;
	}

	public List<Banknote> getFiveTLList() {
		return fiveTLList;
	}

	public void setFiveTLList(List<Banknote> fiveTLList) {
		this.fiveTLList = fiveTLList;
	}

	public List<Banknote> getTenTLList() {
		return tenTLList;
	}

	public void setTenTLList(List<Banknote> tenTLList) {
		this.tenTLList = tenTLList;
	}

	public List<Banknote> getTwentyTLList() {
		return twentyTLList;
	}

	public void setTwentyTLList(List<Banknote> twentyTLList) {
		this.twentyTLList = twentyTLList;
	}

	public List<Banknote> getFiftyTLList() {
		return fiftyTLList;
	}

	public void setFiftyTLList(List<Banknote> fiftyTLList) {
		this.fiftyTLList = fiftyTLList;
	}

	public List<Banknote> getHundredTLList() {
		return hundredTLList;
	}

	public void setHundredTLList(List<Banknote> hundredTLList) {
		this.hundredTLList = hundredTLList;
	}

	public List<Banknote> getTwoHundredTLList() {
		return twoHundredTLList;
	}

	public void setTwoHundredTLList(List<Banknote> twoHundredTLList) {
		this.twoHundredTLList = twoHundredTLList;
	}

}

package deneme;

public class WithdrawFailException extends Exception {
	
	public static final String UNACCEPTABLE_AMOUNT = "Unacceptable amount";
	public static final String UNACCEPTABLE_FOR_PRODUCT = "Amount must be product of 5 TL";
	
	WithdrawFailException(String message) {
		super(message);
	}
}

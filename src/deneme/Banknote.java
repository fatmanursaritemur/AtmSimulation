package deneme;

import java.math.BigDecimal;

public class Banknote {
	
	private BigDecimal value;
	
   public Banknote(BigDecimal valu) {
	value=valu;
 }
	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
}

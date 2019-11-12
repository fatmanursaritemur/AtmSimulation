package deneme;

public class WithdrawAvailableBanknotes {
	private int availabel5Count;
	private int availabel10Count;
	private int availabel20Count;
	private int availabel50Count;
	private int availabel100Count;
	private int availabel200Count;

	WithdrawAvailableBanknotes(int availabel200Count, int availabel100Count, int availabel50Count, int availabel20Count,
			int availabel10Count, int availabel5Count) {
		
			this.availabel200Count = availabel200Count;
			this.availabel100Count = availabel100Count;
			this.availabel50Count = availabel50Count;
			this.availabel20Count = availabel20Count;
			this.availabel10Count = availabel10Count;
			this.availabel5Count = availabel5Count;
	}

	public int getAvailabel5Count() {
		return availabel5Count;
	}

	public void setAvailabel5Count(int availabel5Count) {
		this.availabel5Count = availabel5Count;
	}

	public int getAvailabel10Count() {
		return availabel10Count;
	}

	public void setAvailabel10Count(int availabel10Count) {
		this.availabel10Count = availabel10Count;
	}

	public int getAvailabel20Count() {
		return availabel20Count;
	}

	public void setAvailabel20Count(int availabel20Count) {
		this.availabel20Count = availabel20Count;
	}

	public int getAvailabel50Count() {
		return availabel50Count;
	}

	public void setAvailabel50Count(int availabel50Count) {
		this.availabel50Count = availabel50Count;
	}

	public int getAvailabel100Count() {
		return availabel100Count;
	}

	public void setAvailabel100Count(int availabel100Count) {
		this.availabel100Count = availabel100Count;
	}

	public int getAvailabel200Count() {
		return availabel200Count;
	}

	public void setAvailabel200Count(int availabel200Count) {
		this.availabel200Count = availabel200Count;
	}
}
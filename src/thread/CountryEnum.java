package thread;

public enum CountryEnum {

	ONE(1,"��"),TWO(2,"κ"),THREE(3,"��"),FOUR(4,"��"),FIVE(5,"��"),SIX(6,"��");
	
	private Integer retCode;
	private String retMsg;
	public Integer getRetCode() {
		return retCode;
	}
	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	private CountryEnum(Integer retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}
	public static CountryEnum forEachCountryEnums(Integer index){
		for (CountryEnum element : values()) {
			if(element.getRetCode()==index){
				return element;
			}
		}
		return null;
	}
}

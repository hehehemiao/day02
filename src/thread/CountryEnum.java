package thread;

public enum CountryEnum {

	ONE(1,"º«"),TWO(2,"Îº"),THREE(3,"ÕÔ"),FOUR(4,"Æë"),FIVE(5,"³þ"),SIX(6,"Ñà");
	
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

public class Tool {

	private String toolCode;
	private String toolType;
	private String toolBrand;
	
	public Tool(String toolCode, String toolType, String toolBrand) {
		this.toolCode = toolCode;
		this.toolType = toolType;
		this.toolBrand = toolBrand;
	}
	
	public String getToolCode() {
		return toolCode;
	}
	public String getToolType() {
		return toolType;
	}
	public String getToolBrand() {
		return toolBrand;
	}	
}
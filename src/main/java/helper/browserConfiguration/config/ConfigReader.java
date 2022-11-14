package helper.browserConfiguration.config;

public interface ConfigReader {
	
	public int getImpliciteWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public String getPageUrl();

	public String getPageTitle();
	public String getLoginName();
	public String getPassword();

}

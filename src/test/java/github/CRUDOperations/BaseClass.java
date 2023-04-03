package github.CRUDOperations;

import static io.restassured.RestAssured.*;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import genericLibraries.IEndPointsAndPaths;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesUtility;

public class BaseClass {

	protected PropertiesUtility property;
	protected JavaUtility javaUtil;
	public static String repoName;
	
	@BeforeMethod
	public void methodConfig() {
		property = new PropertiesUtility();
		property.propertiesInitialization(IEndPointsAndPaths.propertiesPath);
		javaUtil = new JavaUtility();
		
		baseURI = "https://api.github.com";
		
	}
	
	@AfterMethod
	public void methodTearDown() {
		Reporter.log("Request completed", true);
	}
}

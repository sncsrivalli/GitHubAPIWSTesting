package github.CRUDOperations;

import org.testng.annotations.Test;

import genericLibraries.IEndPointsAndPaths;
import io.restassured.http.ContentType;
import pojoClasses.RepositoryLib;

import static io.restassured.RestAssured.*;

public class UpdateRepoTest extends BaseClass {

	@Test
	public void updateRepoTest() {
//		RepositoryLib obj = new RepositoryLib();
//	
//		obj.setDescription();
//		obj.setRepoStatus(true);
		
		given()
			.formParam("description", "Just For Fun")
			.formParam("private", true)
			.contentType(ContentType.JSON)
			.pathParam("owner", property.fetchParameter("owner"))
			.pathParam("repo", property.fetchParameter("repo"))
		.when()
			.patch(IEndPointsAndPaths.patchRepo)
		.then()
			.log().all()
			.assertThat().statusCode(200);
	}
}

package github.CRUDOperations;

import org.testng.annotations.Test;

import genericLibraries.IEndPointsAndPaths;

import static io.restassured.RestAssured.*;

public class SearchReposTest extends BaseClass {

	@Test
	public void searchRepoTest() {
		given()
			.queryParam("q", property.fetchParameter("repoName"))
			.queryParam("sort", property.fetchParameter("sort"))
		.when()
			.get(IEndPointsAndPaths.searchRepos)
		.then()
			.log().all()
			.assertThat()
				.statusCode(200);
	}
}

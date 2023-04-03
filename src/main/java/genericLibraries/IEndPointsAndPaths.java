package genericLibraries;

public interface IEndPointsAndPaths {

	String postforAuthUser = "/user/repos";
	String getRepoForAuthUser = "/user/repos";
	String getAllUserRepo = "/users/{username}/repos";
	String getRepoForOwner = "/repos/{owner}/{repo}";
	String patchRepo = "/repos/{owner}/{repo}";
	String deleteRepo = "/repos/{owner}/{repo}";
	String searchRepos = "/search/repositories";
	
	String propertiesPath = System.getProperty("user.dir")+"/src/test/resources/pathParameters.properties";
}

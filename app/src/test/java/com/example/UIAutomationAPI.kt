import android.util.JsonReader
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.Unirest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import java.io.File
import java.io.StringReader
import org.json.JSONObject

class UIAutomationAPI {
    var urlBase =
        "https://testcloud.vodafone.com/" // modify hostname and port as applicable your environment
    var stGridKey =
        "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoyODkxMDEsInhwLnAiOjIsInhwLm0iOjE2MDAwNjIwNzQyMzQsImV4cCI6MTkxNTQyMjA3NCwiaXNzIjoiY29tLmV4cGVyaXRlc3QifQ.6DD9Cm4xU6zxhrse8KtQwfcySIaXB0mp8leRp0ErzlM" //seetest key access
    var url = "$urlBase/api/v1/test-run/execute-test-run"

 /*   var pathToTestApp =
        "C:\\Users\\SinghP90\\Desktop\\Automation\\EspressoTests\\src\\test\\resources\\apk\\ui-automation-scripts-acceptancePreProd-debug-androidTest1.apk" //path to the test app - for this case use the test/resource folder
    var pathToApp =
        "C:\\Users\\SinghP90\\Desktop\\Automation\\EspressoTests\\src\\test\\resources\\apk\\Vodafone_Smartlife_v10.0.0-acceptanceProd-release.apk" //path to the app - for this case use the test/resource folder*/
    var reporterLink = ""
    var pathToTestApp =""
    var pathToApp =""

    //execute espresso tests using cloud environment
    @Throws(Exception::class)
    fun AM_ExecuteEspressoTest() {
        val path = System.getProperty("user.dir")
        // pathToTestApp=path+"\\build\\outputs\\apk\\androidTest\\debug\\app-debug-androidTest.apk"
        //pathToApp=path+"\\build\\outputs\\apk\\debug\\app-debug.apk"
        pathToTestApp="\\app\\apk\\app-debug-androidTest.apk"
        pathToApp="\\app\\apk\\app-debug.apk"
        println("Working Directory = $pathToApp")
        val app = File(pathToApp)
        val testApp = File(pathToTestApp)
        Unirest.setTimeouts(0, 0) //set infinity timeout for post request
        val response: HttpResponse<String> = Unirest.post(url).header(
            "authorization",
            "Bearer $stGridKey"
        ) .field("executionType", "espresso")
            .field("runningType", "fastFeedback")
            .field("deviceQueries", "@name='Mate20Pro'")
            .field("creationTimeout", "60000")
            .field("useUIAutomator", "true")
            .field("app", app)
            .field("testApp", testApp)
            .asString()

        System.out.println(response.code)
        System.out.println(response.getBody())
        if (response.code!== 200) {
            throw Exception("HTTP response not valid - " + response.getBody())
        }
        val jsonObj = JSONObject(response.getBody())
        val testResults: JSONObject = jsonObj.getJSONObject("data")
        val totalTests: String = testResults.getString("Total number of tests")
        println("Total number of tests: $totalTests")

        println("Total number of tests: $totalTests")
        val passedTests: String = testResults.getString("Number of passed tests")
        println("Number of passed tests: $passedTests")
        val failedTests: String = testResults.getString("Number of failed tests")
        println("Number of failed tests: $failedTests")
        reporterLink = testResults.getString("Link to Reporter")
        //Assert.assertTrue("From the total number of tests, " + failedTests + " failed", Integer.parseInt(failedTests) == 0);
      /*  val jsonReader: JsonReader = Json.createReader(StringReader(response.getBody()))
          val jobj: JsonObject = jsonReader.readObject()
          val testResults: JsonObject = jobj.getJsonObject("data")

        val jsonObj = JSONObject(response.getBody().substring(response.getBody().indexOf("{"), response.getBody().lastIndexOf("}") + 1))
        val foodJson = jsonObj.getJSONArray("Foods")
        for (i in 0..foodJson!!.length() - 1) {
            val categories = FoodCategoryObject()
            val name = foodJson.getJSONObject(i).getString("FoodName")
            categories.name = name
        }
          val totalTests: String = testResults.getString("Total number of tests")
          println("Total number of tests: $totalTests")
          val passedTests: String = testResults.getString("Number of passed tests")
          println("Number of passed tests: $passedTests")
          val failedTests: String = testResults.getString("Number of failed tests")
          println("Number of failed tests: $failedTests")
          reporterLink = testResults.getString("Link to Reporter")*/
          //Assert.assertTrue("From the total number of tests, " + failedTests + " failed", Integer.parseInt(failedTests) == 0);

    }


    @Test
    @Throws(Exception::class)
    fun AM_ExecuteTestRun() {
        AM_ExecuteEspressoTest()
    }


}
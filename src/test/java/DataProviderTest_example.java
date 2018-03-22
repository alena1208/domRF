import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest_example {

    @DataProvider
    public Object[][] dp() {
        return new Object[][]
                {
                        {1, "string1"},
                        {2, "string2"}
                };
    }

    @Test(dataProvider = "dp")
    public void dpTest(int i, String s) {
        System.out.println("int: " + i + " " + "String: " + s);
    }
}

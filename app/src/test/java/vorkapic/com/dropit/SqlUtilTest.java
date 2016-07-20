package vorkapic.com.dropit;

import org.junit.Assert;
import org.junit.Test;

import vorkapic.com.dropit.database.SqlUtil;

/**
 * Created by dvor on 20/07/16.
 */
public class SqlUtilTest {

    @Test
    public void TestCreateSQL() {
        String table_name = "TESTTABLE";
        String[] columns = {"COL_ONE", "COL_TWO", "COL_THREE"};
        String wantedSql = "SELECT COL_ONE, COL_TWO, COL_THREE FROM " + table_name + "";

        String resultSql = SqlUtil.select(table_name, columns);

        Assert.assertTrue(wantedSql.equals(resultSql));
    }
}

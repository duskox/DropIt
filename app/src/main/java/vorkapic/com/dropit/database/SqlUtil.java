package vorkapic.com.dropit.database;

/**
 * Created by dvor on 19/07/16.
 */
public class SqlUtil {

    private SqlUtil(){}

    /**
     * Forms a create table command out of the given values.
     */
    public static String createTable(String tableName, String[] columns, String[] foreignKeyDefinitions) {
        StringBuilder command = new StringBuilder("CREATE TABLE IF NOT EXISTS ").
                append(tableName).append("( ");

        for (int i = 0; i < columns.length; i++) {
            command.append(columns[i]);
            if (i != columns.length - 1) {
                command.append(", ");
            }
        }

        if (foreignKeyDefinitions != null && foreignKeyDefinitions.length > 0) {
            for (String foreignKeyDefinition : foreignKeyDefinitions) {
                command.append(", ").append(foreignKeyDefinition);
            }
        }
        command.append(");");
        return command.toString();
    }

    /**
     * Returns a standard SQL SELECT command.
     */
    public static String select(String tableName, Object[] fieldNames) {
        StringBuilder command = new StringBuilder("SELECT ");
        for (int i = 0; i < fieldNames.length; i++) {
            command.append(fieldNames[i].toString());
            if (i != fieldNames.length - 1) {
                command.append(", ");
            } else {
                command.append(" ");
                break;
            }
        }
        command.append("FROM ").append(tableName);
        return command.toString();
    }

}

package liquibase.ext.hana.datatype;

import liquibase.database.Database;
import liquibase.datatype.DataTypeInfo;
import liquibase.datatype.DatabaseDataType;
import liquibase.datatype.LiquibaseDataType;
import liquibase.datatype.core.NVarcharType;
import liquibase.ext.hana.HanaDatabase;

@DataTypeInfo(name = "nvarchar", aliases = { "java.sql.Types.NVARCHAR", "nvarchar2", "shorttext",
		"national" }, minParameters = 0, maxParameters = 1, priority = LiquibaseDataType.PRIORITY_DATABASE)
public class NVarcharTypeHana extends NVarcharType {

	@Override
	public int getPriority() {
		return PRIORITY_DATABASE;
	}

	@Override
	public boolean supports(Database database) {
		return database instanceof HanaDatabase;
	}

	@Override
	public DatabaseDataType toDatabaseDataType(Database database) {
		Object[] parameters = getParameters();
		if (parameters.length > 0) {
			return new DatabaseDataType("NVARCHAR", parameters[0]);
		}
		return new DatabaseDataType("NVARCHAR");
	}

}
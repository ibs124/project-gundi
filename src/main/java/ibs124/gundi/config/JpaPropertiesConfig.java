package ibs124.gundi.config;

public abstract class JpaPropertiesConfig {

    public static final String COULUMN_CREATED_AT = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP";

    public static final String COULUMN_UPDATED_AT = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP";

    public static final String COLUMN_BOOLEAN = "BOOLEAN DEFAULT FALSE";
}

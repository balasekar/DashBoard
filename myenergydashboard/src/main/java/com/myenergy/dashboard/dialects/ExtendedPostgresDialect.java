package com.myenergy.dashboard.dialects;

import java.io.Serializable;
import java.sql.Types;

import org.hibernate.dialect.PostgreSQLDialect;

public class ExtendedPostgresDialect extends PostgreSQLDialect implements Serializable{
	
   public ExtendedPostgresDialect() {
	      super();
	      registerColumnType( Types.OTHER, "interval" );
	   }

}

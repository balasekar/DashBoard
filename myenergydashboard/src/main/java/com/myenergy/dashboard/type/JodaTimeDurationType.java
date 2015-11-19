package com.myenergy.dashboard.type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
import org.postgresql.util.PGInterval;

public class JodaTimeDurationType implements UserType {    

private static final int[] SQL_TYPES = { Types.OTHER };

public int[] sqlTypes() {
    return SQL_TYPES;
}

@SuppressWarnings("rawtypes")
public Class returnedClass() {
    return Integer.class;
}

public boolean equals(Object x, Object y) throws HibernateException {
    return x.equals(y);
}

public int hashCode(Object x) throws HibernateException {
    return x.hashCode();
}

public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
        throws HibernateException, SQLException {
    String interval = rs.getString(names[0]);
    if (rs.wasNull() || interval == null) {
        return null;
    }
    PGInterval pgInterval = new PGInterval(interval);
    Date epoch = new Date(0l);
    pgInterval.add(epoch);
    return Integer.valueOf((int)epoch.getTime() / 1000);
}

public static String getInterval(int value){
    return new PGInterval(0, 0, 0, 0, 0, value).getValue();
}


public void nullSafeSet(PreparedStatement st, Object value, int index)
        throws HibernateException, SQLException {
    if (value == null) {
        st.setNull(index, Types.VARCHAR);
    } else {
        //this http://postgresql.1045698.n5.nabble.com/Inserting-Information-in-PostgreSQL-interval-td2175203.html#a2175205
        st.setObject(index, getInterval(((Integer) value).intValue()), Types.OTHER);
    }
}

public Object deepCopy(Object value) throws HibernateException {
    return value;
}

public boolean isMutable() {
    return false;
}

public Serializable disassemble(Object value) throws HibernateException {
    return (Serializable) value;
}

public Object assemble(Serializable cached, Object owner)
        throws HibernateException {
    return cached;
}

public Object replace(Object original, Object target, Object owner)
        throws HibernateException {
    return original;
}

public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor arg2, Object owner)
		throws HibernateException, SQLException {
    String interval = rs.getString(names[0]);
    if (rs.wasNull() || interval == null) {
        return null;
    }
    PGInterval pgInterval = new PGInterval(interval);
    Date epoch = new Date(0l);
    pgInterval.add(epoch);
    return Integer.valueOf((int)epoch.getTime() / 1000);
}

public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor arg3)
		throws HibernateException, SQLException {
    if (value == null) {
        st.setNull(index, Types.VARCHAR);
    } else {
        //this http://postgresql.1045698.n5.nabble.com/Inserting-Information-in-PostgreSQL-interval-td2175203.html#a2175205
        st.setObject(index, getInterval(((Integer) value).intValue()), Types.OTHER);
    }
}

}

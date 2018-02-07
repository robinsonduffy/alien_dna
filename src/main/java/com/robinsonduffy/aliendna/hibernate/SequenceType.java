package com.robinsonduffy.aliendna.hibernate;

import com.robinsonduffy.aliendna.model.genotype.Sequence;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StringType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SequenceType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[] { VarcharTypeDescriptor.INSTANCE.getSqlType() };
    }

    @Override
    public Class returnedClass() {
        return Sequence.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return x.equals(y);
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names, SessionImplementor sessionImplementor, Object o) throws HibernateException, SQLException {
        String value = (String) StringType.INSTANCE.get(resultSet, names[0], sessionImplementor);
        if (value == null) {
            return null;
        } else {
            return Sequence.fromString(value);
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SessionImplementor sessionImplementor) throws HibernateException, SQLException {
        if (o == null) {
            StringType.INSTANCE.set(preparedStatement, null, i, sessionImplementor);
        } else {
            StringType.INSTANCE.set(preparedStatement, o.toString(), i, sessionImplementor);
        }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        return o;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return null;
    }
}

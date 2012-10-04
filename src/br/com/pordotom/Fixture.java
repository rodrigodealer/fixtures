package br.com.pordotom;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import com.thoughtworks.xstream.XStream;

public class Fixture {

    private Class<?> klazz;
    private HashMap<String, Object> params;
    private File file;

    @SuppressWarnings("unchecked")
    public <T> T create() throws FixtureException {
        if (isUsingParams()) {
            return extractByParams();
        }
        XStream xstream = new XStream();
        return (T) xstream.fromXML(this.file);
    }

    private boolean isUsingParams() {
        return this.file == null || !this.file.isFile();
    }

    @SuppressWarnings("unchecked")
    private <T> T extractByParams() throws FixtureException {
        T iClass;
        try {
            iClass = (T) klazz.newInstance();
        } catch (InstantiationException e) {
            throw new FixtureException(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            throw new FixtureException(e.getMessage(), e);
        }
        for (String field : params.keySet()) {
            try {
                Method method =
                        iClass.getClass().getMethod(FixtureUtil.getCapitalizedSetter(field),
                                params.get(field).getClass());
                method.invoke(iClass, params.get(field));
            } catch (SecurityException e) {
                throw new FixtureException(e.getMessage(), e);
            } catch (NoSuchMethodException e) {
                throw new FixtureException(e.getMessage(), e);
            } catch (InvocationTargetException e) {
                throw new FixtureException(e.getMessage(), e);
            } catch (IllegalAccessException e) {
                throw new FixtureException(e.getMessage(), e);
            }

        }
        return iClass;
    }

    public Fixture with(Class<?> klazz) {
        this.klazz = klazz;
        return this;
    }

    public Fixture usingFile(String filePath) throws FixtureException {
        file = new File(filePath);
        if (!file.isFile()) {
            throw new FixtureException("File not found: " + filePath);
        }
        return this;
    }

    public Fixture andParam(HashMap<String, Object> values) {
        this.params = values;
        return this;
    }
}

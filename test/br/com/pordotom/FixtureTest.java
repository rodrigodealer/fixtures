package br.com.pordotom;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class FixtureTest {

    @Test
    public void shouldCreateFixtureWithStrings() throws FixtureException {
        Fixture fixture = new Fixture();
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("name", "value");
        values.put("email", "email");
        User user = fixture.with(User.class).andParam(values).create();
        Assert.assertEquals("value", user.getName());
        Assert.assertEquals("email", user.getEmail());
    }

    @Test(expected = FixtureException.class)
    public void shouldCreateFixtureWithDouble() throws FixtureException {
        Fixture fixture = new Fixture();
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("name", new Double(2));
        values.put("email", "email");
        User user = fixture.with(User.class).andParam(values).create();
        Assert.assertEquals("value", user.getName());
        Assert.assertEquals("email", user.getEmail());
    }

    @Test
    public void shouldCreateFixtureWithDoubleAndVerifyMessage() {
        Fixture fixture = new Fixture();
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("name", new Double(2));
        values.put("email", "email");
        try {
            fixture.with(User.class).andParam(values).create();
        } catch (FixtureException e) {
            Assert.assertEquals(
                    "Ocorreu um erro: java.lang.NoSuchMethodException: br.com.pordotom.User.setName(java.lang.Double) in br.com.pordotom.User.setName(java.lang.Double)",
                    e.getMessage());
        }
    }

    @Test
    public void shouldCreateFixtureWithInteger() throws FixtureException {
        Fixture fixture = new Fixture();
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("name", "value");
        values.put("email", "email");
        values.put("age", 20);
        User user = fixture.with(User.class).andParam(values).create();
        Assert.assertEquals("value", user.getName());
        Assert.assertEquals("email", user.getEmail());
        Assert.assertEquals(new Integer(20), user.getAge());
    }

    @Test
    public void shouldCreateFixtureWithBoolean() throws FixtureException {
        Fixture fixture = new Fixture();
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("name", "value");
        values.put("email", "email");
        values.put("alive", true);
        User user = fixture.with(User.class).andParam(values).create();
        Assert.assertEquals("value", user.getName());
        Assert.assertEquals("email", user.getEmail());
        Assert.assertTrue(user.isAlive());
    }

    @Test
    public void shouldCreateFixtureWithLong() throws FixtureException {
        Fixture fixture = new Fixture();
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("name", "value");
        values.put("email", "email");
        values.put("daysAlive", 8000L);
        User user = fixture.with(User.class).andParam(values).create();
        Assert.assertEquals("value", user.getName());
        Assert.assertEquals("email", user.getEmail());
        Assert.assertEquals(new Long(8000L), user.getDaysAlive());
    }

    @Test
    public void shouldCreateFixtureUsingXML() throws FixtureException, FileNotFoundException {
        Fixture fixture = new Fixture();
        User user = fixture.with(User.class).usingFile("test/base/user.xml").create();
        Assert.assertEquals("Joe", user.getName());
        Assert.assertEquals("joe@walnes.com.br", user.getEmail());
    }
}

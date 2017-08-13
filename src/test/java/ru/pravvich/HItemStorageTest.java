package ru.pravvich;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HItemStorageTest {

    @Test
    public void whenSaveItemToDatabaseThenItemContainInDB() {

        final ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("hibernate-context.xml");

        final HItemStorage storage = context.getBean(HItemStorage.class);

        final Item item = new Item();
        item.setName("test");
        item.setDescription("test");

        final Item result = storage.save(item);

        assertThat(storage.getAll().contains(result), is(true));
    }

}
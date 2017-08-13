package ru.pravvich;

import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author : Pavel Ravvich.
 * Created : 13.08.17.
 */
@Component
public class HItemStorage implements Storage {
    /**
     * Hibernate template.
     */
    private final SessionFactoryImpl template;

    @Autowired
    public HItemStorage(SessionFactoryImpl template) {
        this.template = template;
    }

    @Override
    public List<Item> getAll() {

        try (final Session session = template.openSession()){

            return session.createQuery("from Item", Item.class).list();
        }
    }

    @Transactional
    @Override
    public Item save(final Item item) {

        try (final Session session = template.openSession()){

            item.setId((int) session.save(item));

            return item;
        }
    }
}

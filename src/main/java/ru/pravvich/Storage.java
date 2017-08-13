package ru.pravvich;

import java.util.List;

public interface Storage {
    List<Item> getAll();
    Item save(Item item);
}

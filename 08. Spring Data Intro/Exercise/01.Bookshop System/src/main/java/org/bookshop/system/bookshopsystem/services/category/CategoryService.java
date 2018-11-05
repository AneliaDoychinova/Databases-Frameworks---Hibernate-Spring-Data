package org.bookshop.system.bookshopsystem.services.category;

import org.bookshop.system.bookshopsystem.models.entities.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    void save(List<Category> categories);

    List<Category> getAll();
}

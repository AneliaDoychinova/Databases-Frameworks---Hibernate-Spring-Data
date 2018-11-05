package org.bookshop.system.bookshopsystem.services.category;

import org.bookshop.system.bookshopsystem.models.entities.Category;
import org.bookshop.system.bookshopsystem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void save(List<Category> categories) {
        this.categoryRepository.saveAll(categories);
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }
}

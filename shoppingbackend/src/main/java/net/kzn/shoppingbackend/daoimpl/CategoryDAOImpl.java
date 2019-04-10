package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("anurag1");
		category.setDescription("some description 1");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("anurag2");
		category.setDescription("some description 2");
		category.setImageURL("CAT_2.png");
		categories.add(category);
		
		
		category = new Category();
		category.setId(3);
		category.setName("anurag3");
		category.setDescription("some description 3");
		category.setImageURL("CAT_3.png");
		categories.add(category);
		
	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		
		for (Category category : categories) {
			
			if (id == category.getId()) {
				return category;
			}
			
		}
		
		return null;
	}

	
	
}

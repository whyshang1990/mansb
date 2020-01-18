package com.why.first.mansb.repository;

import com.why.first.mansb.domain.CategoryDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<CategoryDO, String> {

}

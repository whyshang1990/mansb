package com.why.first.mansb.repository;

import com.why.first.mansb.domain.CategoryDO;
import com.why.first.mansb.dto.CategoryDTO;
import com.why.first.mansb.dto.SubCategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<CategoryDO, String> {
    @Query("select new com.why.first.mansb.dto.CategoryDTO(o.uuid, o.name)" +
            " from CategoryDO o" +
            " where o.level = 0")
    List<CategoryDTO> getTops();

    @Query(value = "select new com.why.first.mansb.dto.SubCategoryDTO(o.parentUuid, o.uuid, o.name)" +
            " from CategoryDO o " +
            "where o.level=1")
    List<SubCategoryDTO> getSubs();
}

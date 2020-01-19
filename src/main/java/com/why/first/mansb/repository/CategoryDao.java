package com.why.first.mansb.repository;

import com.why.first.mansb.domain.CategoryDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<CategoryDO, String> {
    List<CategoryDO> findByLevel(Integer level);

    @Query(value = "select o from CategoryDO o where o.level=:level and o.parentUuid=:parentUuid")
    List<CategoryDO> findMinors(@Param("level") Integer level, @Param("parentUuid") String parentUuid);
}

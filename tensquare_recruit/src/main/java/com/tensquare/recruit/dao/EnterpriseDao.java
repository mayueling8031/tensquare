package com.tensquare.recruit.dao;

import com.tensquare.recruit.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;


public interface EnterpriseDao extends JpaRepository<Enterprise,String>, JpaSpecificationExecutor<Enterprise> {
    /**
     根据热门状态获取企业列表
     * @param iShot
     *  @return
     */
    public List<Enterprise> findByIshot(String iShot);
}

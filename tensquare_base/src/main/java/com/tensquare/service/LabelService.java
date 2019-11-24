package com.tensquare.service;

import com.tensquare.dao.LabelDao;
import com.tensquare.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll(){
        return labelDao.findAll();
    }

    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    public void save(Label label){
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    public void update(Label label){
        labelDao.save(label);
    }

    public void deleteById(String id){
        labelDao.deleteById(id);
    }


    public List<Label> findASearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                if (label.getLabelname()!=null&&!"".equals(label.getLabelname())){
                    predicateList.add(cb.like(root.get("labelname").as(String.class),"%"+label.getLabelname()+"%"));
                }
                if(label.getState()!=null && !"".equals(label.getState())){
                    predicateList.add(cb.equal( root.get("state").as(String.class),label.getState()));
                }
                if(label.getRecommend()!=null && !"".equals(label.getRecommend())){
                    predicateList.add(cb.equal( root.get("recommend").as(String.class),label.getRecommend()));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        });
    }
}

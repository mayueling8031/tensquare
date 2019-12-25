package com.tensquare.service;

import com.tensquare.dao.CityDao;
import com.tensquare.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import java.util.Map;

@Service
@Transactional
public class CityService {
    @Autowired
    private CityDao cityDao;

    @Autowired
    private IdWorker idWorker;

    public List<City> findAll() {
        return cityDao.findAll();
    }

    public City findById(String id) {
        return cityDao.findById(id).get();
    }

    public void save(City city) {
        city.setId(idWorker.nextId() + "");
        cityDao.save(city);
    }

    public void update(City city) {
        cityDao.save(city);
    }

    public void deleteById(String id) {
        cityDao.deleteById(id);
    }


    /**
     * 条件查询
     *
     * @param city
     * @return
     */
    public List<City> findASearch(City city) {
        return cityDao.findAll(new Specification<City>() {
            @Override
            public Predicate toPredicate(Root<City> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                if (city.getName() != null && !"".equals(city.getName())) {
                    predicateList.add(cb.like(root.get("labelname").as(String.class), "%" + city.getName() + "%"));
                }
                if (city.getIshot() != null && !"".equals(city.getIshot())) {
                    predicateList.add(cb.equal(root.get("state").as(String.class), city.getIshot()));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        });
    }

    /*** 构建查询条件
     ** @param searchMap
     ** @return
     */
    private Specification<City> createSpecification(Map searchMap) {
        return new Specification<City>() {
            @Override
            public Predicate toPredicate(Root<City> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
                    predicateList.add(cb.like(root.get("name").as(String.class), "%" + (String) searchMap.get("name") + "%"));
                }
                if (searchMap.get("ishot") != null && !"".equals(searchMap.get("ishot"))) {
                    predicateList.add(cb.equal(root.get("ishot").as(String.class), (String) searchMap.get("ishot")));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }

    /**
     * 条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public Page<City> findSearchPage(Map searchMap, int page, int size) {
        Specification<City> specification = createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return cityDao.findAll(specification, pageRequest);
    }
}

package com.xgxx.springboot.entities;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @ClassName Bookrepository
 * @Description TODO
 * @Author Dx
 * @Date 2020/9/27 15:35
 * @Version 1.0
 **/
public interface  Bookrepository extends ElasticsearchRepository<Employee,Integer> {
    List<Employee> findBookById(int i);

    List<Employee> findEmployeeByLastNameLike(String lastName);
}

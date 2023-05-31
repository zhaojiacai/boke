package com.dev.blog.dao;

import com.dev.blog.po.User;
import org.hibernate.cfg.JPAIndexHolder;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);

}

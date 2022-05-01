package com.jacob.superschlag.repository;

import com.jacob.superschlag.entity.Avatar;
import com.jacob.superschlag.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, String> {
}

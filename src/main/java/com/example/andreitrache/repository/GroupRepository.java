package com.example.andreitrache.repository;

import com.example.andreitrache.model.Connection;
import com.example.andreitrache.model.Group;
import com.example.andreitrache.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository <Group, Long> {
    @Query("SELECT gm.user FROM GroupMember gm WHERE gm.group.id = :groupId")
    List<User> findUsersByGroupId(@Param("groupId") Long groupId);
    @Modifying
    @Query("DELETE FROM GroupMember gm WHERE gm.user.id = :userId AND gm.group.id = :groupId")
    void removeUserFromGroup(@Param("groupId") Long groupId, @Param("userId") Long userId);
}

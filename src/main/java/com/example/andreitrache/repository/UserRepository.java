package com.example.andreitrache.repository;

import com.example.andreitrache.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Connection c WHERE c.user.id = :userId")
    void deleteFirstConnections(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Connection c WHERE c.connection.id = :userId")
    void deleteSecondConnections(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Education e WHERE e.user.id = :userId")
    void deleteEducation(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Experience e WHERE e.user.id = :userId")
    void deleteExperience(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM GroupMember g WHERE g.user.id = :userId")
    void deleteGroupMember(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Profile p WHERE p.user.id = :userId")
    void deleteProfile(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Skill s WHERE s.user.id = :userId")
    void deleteSkills(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.id = :userId")
    void deleteUser(@Param("userId") Long userId);
}

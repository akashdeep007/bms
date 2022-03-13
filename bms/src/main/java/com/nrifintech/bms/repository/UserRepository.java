package com.nrifintech.bms.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nrifintech.bms.entity.Bus;
import com.nrifintech.bms.entity.User;

@Repository
public interface UserRepository extends AbstractBaseRepository<User, Integer> {
	User findByEmailAndPassword(String email, String password);
	User findByEmail(String email);
	User findByMobileNo(String mobileNo);
	
//	@Query(value="update user set name=?1, phone_no=?2 where userid=?3;", nativeQuery = true)
//	public void updateUser(String name, String mobile, int userid);
	
	@Modifying(clearAutomatically = true)
	@Query("update User user set user.name =:name, user.mobileNo =:mobile where user.userid =:userid")
	@Transactional
	void updateUser(@Param("name") String name, @Param("mobile") String mobile, @Param("userid") int userid);
}

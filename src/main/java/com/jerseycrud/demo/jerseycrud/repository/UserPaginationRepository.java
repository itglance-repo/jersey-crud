package com.jerseycrud.demo.jerseycrud.repository;

import com.jerseycrud.demo.jerseycrud.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPaginationRepository extends PagingAndSortingRepository<User,Long> {
}

package com.globallogic.Repository;

import com.globallogic.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}

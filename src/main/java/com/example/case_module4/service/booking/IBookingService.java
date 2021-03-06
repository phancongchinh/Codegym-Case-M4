package com.example.case_module4.service.booking;

import com.example.case_module4.model.Booking;
import com.example.case_module4.model.User;
import com.example.case_module4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookingService extends IGeneralService<Booking> {
    Page<Booking> findAllByGuest(User guest, Pageable pageable);

    Page<Booking> findAll(Pageable pageable);
}

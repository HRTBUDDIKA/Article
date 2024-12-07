package com.Start.service.inteface;

import com.Start.dao.LoginRequest;
import com.Start.dao.Response;
import com.Start.entity.User;

public interface IUserService {

    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String userId);
}

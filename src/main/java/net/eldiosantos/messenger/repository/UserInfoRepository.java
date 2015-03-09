package net.eldiosantos.messenger.repository;

import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.repository.interfaces.Repository;

public interface UserInfoRepository extends Repository<UserInfo, Long> {
    public UserInfo validateLogin(String username, String password);
    public UserInfo validateToken(String token);
}

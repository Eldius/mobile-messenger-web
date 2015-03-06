package net.eldiosantos.viajabessa.repository;

import net.eldiosantos.viajabessa.model.auth.UserInfo;
import net.eldiosantos.viajabessa.repository.interfaces.Repository;

public interface UserInfoRepository extends Repository<UserInfo, Long> {
    public UserInfo validateLogin(String username, String password);
}

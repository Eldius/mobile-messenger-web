package net.eldiosantos.viajabessa.repository.interfaces;

import java.io.Serializable;

public interface Delete<T, K extends Serializable>
{
    public void delete(T element);
}

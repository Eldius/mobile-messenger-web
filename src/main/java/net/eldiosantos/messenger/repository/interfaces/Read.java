package net.eldiosantos.messenger.repository.interfaces;

import java.io.Serializable;
import java.util.List;

public interface Read<T, K extends Serializable>
{
    public T getByPk(K pk);
    public List<T>listAll();
}
package DAO;

import java.util.List;

public abstract class DAO<T> {
    public abstract List<T> selectAll();
    public abstract T selectOne(int id);
    public abstract boolean insert(T entity);
    public abstract boolean update(T entity);
    public abstract boolean delete(int id);
}

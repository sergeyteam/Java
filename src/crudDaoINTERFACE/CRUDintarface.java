package crudDaoINTERFACE;

import java.util.List;

public interface CRUDintarface<T> {
	
	T create(T t);
	List<T> getAll();
	T getByID(int id);
	boolean update(T t);
	boolean delete(T t);
}

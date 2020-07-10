package model;

import java.sql.SQLException;
import java.util.List;

public interface listtaskdao {

	void insertTodo(listtaskdao listtaskdao) throws SQLException;

	listtaskdao selectTodo(long todoId);

	List<listtaskdao> selectAllTodos();

	boolean deleteTodo(int id) throws SQLException;

	boolean updateTodo(listtaskdao todo) throws SQLException;

}
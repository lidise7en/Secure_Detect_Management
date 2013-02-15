package dao;
import java.util.List;

import model.tools;

import dao.BaseDAO;

public interface ToolDAO extends BaseDAO <tools>{
	
	//@param
	//
	public List<tools> findAllByTimeOrder();

}

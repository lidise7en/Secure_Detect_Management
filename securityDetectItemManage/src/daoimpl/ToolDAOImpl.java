package daoimpl;

import java.util.List;


import dao.ToolDAO;
import daoimpl.BaseDAOImpl;
import model.tools;
import org.hibernate.Query;


public class ToolDAOImpl  extends BaseDAOImpl<tools> implements ToolDAO{
	

	public ToolDAOImpl() {
		super(tools.class);
		// TODO Auto-generated constructor stub
	}
	

	public List<tools> findAllByTimeOrder() {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from Idea order by createTime desc");
		return query.list();
	}

}

package connection;

public class DepartmentServiceImp implements IDepartmentService {

	private	DeptDAO dao = new DeptDAO();
	@Override
	public int addDept(Department dept) {
		return dao.addDept(dept);
		// TODO Auto-generated method stub	
	}

	@Override
	public int updateDept(Department dept) {
		// TODO Auto-generated method stub
		return dao.updateDept(dept);
	}

	@Override
	public void getDeptByNo(int dno) {
		// TODO Auto-generated method stub
		dao.getDeptByNo(dno);
	}

	@Override
	public void selectAll() {
		// TODO Auto-generated method stub
		dao.selectAll();
	}

	@Override
	public int deleteDeptByNo(int dno) {
		// TODO Auto-generated method stub
		return dao.deleteDeptByNo(dno);
	}
	public boolean dataValidation(Department dept)
	{
		if(dept.getDno()>99 && dept.getDname().length()>=4 && dept.getLocation().equals(dept.getLocation().toUpperCase()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
	
	


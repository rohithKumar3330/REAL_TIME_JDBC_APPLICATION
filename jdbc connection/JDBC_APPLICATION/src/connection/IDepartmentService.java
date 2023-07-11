package connection;

public interface IDepartmentService {
	
	public int addDept(Department dept);
	public int updateDept(Department dept);
	public void getDeptByNo(int dno);
	public void selectAll();
	public int deleteDeptByNo(int dno);
	public boolean dataValidation(Department dept);
}



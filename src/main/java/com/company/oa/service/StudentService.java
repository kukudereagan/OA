package com.company.oa.service;

import com.company.oa.mapper.StudentMapper;
import com.company.oa.model.Student;
import com.github.pagehelper.PageHelper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;
 

    /**
     * 添加：
     * 在Demo po中的id列加入@GeneratedValue(strategy = GenerationType.IDENTITY) 可自动生成Id,
     * @param demo
     * @return
     */
    public Student insert(Student model){
        //通用mapper中的两个新增方式
        studentMapper.insert(model); //插入所有数据，保存字段值为null的。
       // demoMapper.insertSelective(oa); //只插入字段值不为null的数据。

        int id = model.getId();  //调用插入方法后，通过这样的方式获取插入的数据的新ID
        System.out.println(id);
        return model;
    }

    public List<Student> selectAll(){
        // 单表分页
        //PageHelper.startPage(0,10);

        //单表自定义查询
        //Example company = new Example(Demo.class);

        return studentMapper.selectAll();
    }
    

	public List<Student> getStudents(String filter,Integer pageIndex,Integer pageSize){
        // 单表分页
        PageHelper.startPage(pageIndex,pageSize);
        Example example = new Example(Student.class);
        if(StringUtils.isNotEmpty(filter)) {
            filter = "%" + filter + "%";
            example.createCriteria().andLike("name", filter);
        }

        return studentMapper.selectByExample(example);
    }

	public Student getStudent(Integer id) {
		Student model = new Student();
		model.setId(id);
		return studentMapper.selectOne(model);
	}

	public Student createOrUpdate(Student model) {
        // 新增
        if(model.getId() == null){
        	studentMapper.insert(model);
        }else{
        	studentMapper.updateByPrimaryKeySelective(model);
        }
        return model;	   
	}
	
	public int delete(Integer id) {
		Student model = new Student();
		model.setId(id);
        return studentMapper.deleteByPrimaryKey(model);
    }
}

package com.php.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;*/

import com.php.bean.CData;
import com.php.bean.utils.RegexUtils;
import com.php.dao.CDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class CountKeywordsMain {
	@Autowired
	CDataMapper mapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testMapping(){
		CDataMapper mapper = sqlSession.getMapper(CDataMapper.class);
		
		List<Object> listAll = new ArrayList<>();
		
		Map<String,Object> mapAll = new HashMap<>();
		
		List<CData> list = mapper.selectByExample(null);
		
		for (CData cData : list) {
			listAll = RegexUtils.getEm(cData.getContent());
		}
		
		for(Object obj : listAll) {
			if(!mapAll.containsKey(obj)) {
				mapAll.put((String) obj, 1);
			} else {
				mapAll.put((String) obj, (Integer)mapAll.get(obj) + 1);
			}
		}
		
		System.out.println(mapAll);
		
	}

}

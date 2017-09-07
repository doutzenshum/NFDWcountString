package com.php.dao;

import com.php.bean.CData;
import com.php.bean.CDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CDataMapper {
    long countByExample(CDataExample example);

    int deleteByExample(CDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CData record);

    int insertSelective(CData record);

    List<CData> selectByExample(CDataExample example);

    CData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CData record, @Param("example") CDataExample example);

    int updateByExample(@Param("record") CData record, @Param("example") CDataExample example);

    int updateByPrimaryKeySelective(CData record);

    int updateByPrimaryKey(CData record);
}
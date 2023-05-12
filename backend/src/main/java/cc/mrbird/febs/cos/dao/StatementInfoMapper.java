package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.StatementInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface StatementInfoMapper extends BaseMapper<StatementInfo> {

    /**
     * 分页查询留言板信息
     *
     * @param page
     * @param statementInfo
     * @return
     */
    IPage<LinkedHashMap<String, Object>> selectStatementPage(Page page, @Param("statementInfo") StatementInfo statementInfo);
}

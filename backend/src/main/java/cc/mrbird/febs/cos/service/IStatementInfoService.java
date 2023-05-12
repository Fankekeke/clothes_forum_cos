package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.StatementInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IStatementInfoService extends IService<StatementInfo> {

    /**
     * 分页查询留言板信息
     *
     * @param page
     * @param statementInfo
     * @return
     */
    IPage<LinkedHashMap<String, Object>> selectStatementPage(Page page, StatementInfo statementInfo);

}

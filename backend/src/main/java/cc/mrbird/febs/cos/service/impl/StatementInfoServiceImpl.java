package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.StatementInfo;
import cc.mrbird.febs.cos.dao.StatementInfoMapper;
import cc.mrbird.febs.cos.service.IStatementInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class StatementInfoServiceImpl extends ServiceImpl<StatementInfoMapper, StatementInfo> implements IStatementInfoService {

    /**
     * 分页查询留言板信息
     *
     * @param page
     * @param statementInfo
     * @return
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectStatementPage(Page page, StatementInfo statementInfo) {
        return baseMapper.selectStatementPage(page, statementInfo);
    }
}

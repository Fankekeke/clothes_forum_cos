package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.StatementInfo;
import cc.mrbird.febs.cos.service.IStatementInfoService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/statement-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StatementInfoController {

    private final IStatementInfoService statementInfoService;

    /**
     * 分页查询留言板信息
     *
     * @param page
     * @param statementInfo
     * @return
     */
    @GetMapping("/page")
    public R page(Page page, StatementInfo statementInfo) {
        return R.ok(statementInfoService.selectStatementPage(page, statementInfo));
    }

    @GetMapping("/list")
    public R list() {
        return R.ok(statementInfoService.list());
    }

    /**
     * 新增留言板信息
     *
     * @param statementInfo
     * @return
     */
    @PostMapping
    public R save(StatementInfo statementInfo) {
        statementInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(statementInfoService.save(statementInfo));
    }

    /**
     * 修改留言板信息
     *
     * @param statementInfo
     * @return
     */
    @PutMapping
    public R edit(StatementInfo statementInfo) {
        return R.ok(statementInfoService.updateById(statementInfo));
    }

    /**
     * 删除留言板信息
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(statementInfoService.removeByIds(ids));
    }

}

package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.ClothesInfo;
import cc.mrbird.febs.cos.service.IClothesInfoService;
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
@RequestMapping("/cos/clothes-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClothesInfoController {

    private final IClothesInfoService clothesInfoService;

    /**
     * 分页查询汉服百科信息
     *
     * @param page
     * @param clothesInfo
     * @return
     */
    @GetMapping("/page")
    public R page(Page page, ClothesInfo clothesInfo) {
        return R.ok(clothesInfoService.selectClothesPage(page, clothesInfo));
    }

    @GetMapping("/list")
    public R list() {
        return R.ok(clothesInfoService.list());
    }

    /**
     * 新增汉服百科信息
     *
     * @param clothesInfo
     * @return
     */
    @PostMapping
    public R save(ClothesInfo clothesInfo) {
        clothesInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(clothesInfoService.save(clothesInfo));
    }

    /**
     * 修改汉服百科信息
     *
     * @param clothesInfo
     * @return
     */
    @PutMapping
    public R edit(ClothesInfo clothesInfo) {
        return R.ok(clothesInfoService.updateById(clothesInfo));
    }

    /**
     * 删除汉服百科信息
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(clothesInfoService.removeByIds(ids));
    }

}

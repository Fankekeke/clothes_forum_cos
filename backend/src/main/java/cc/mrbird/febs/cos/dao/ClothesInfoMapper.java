package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.ClothesInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface ClothesInfoMapper extends BaseMapper<ClothesInfo> {

    /**
     * 分页查询汉服百科信息
     *
     * @param page
     * @param clothesInfo
     * @return
     */
    IPage<LinkedHashMap<String, Object>> selectClothesPage(Page page, @Param("clothesInfo") ClothesInfo clothesInfo);
}

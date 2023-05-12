package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.ClothesInfo;
import cc.mrbird.febs.cos.dao.ClothesInfoMapper;
import cc.mrbird.febs.cos.service.IClothesInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class ClothesInfoServiceImpl extends ServiceImpl<ClothesInfoMapper, ClothesInfo> implements IClothesInfoService {

    /**
     * 分页查询汉服百科信息
     *
     * @param page
     * @param clothesInfo
     * @return
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectClothesPage(Page page, ClothesInfo clothesInfo) {
        return baseMapper.selectClothesPage(page, clothesInfo);
    }
}

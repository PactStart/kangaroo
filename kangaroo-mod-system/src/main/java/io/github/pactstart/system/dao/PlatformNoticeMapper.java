package io.github.pactstart.system.dao;

import io.github.pactstart.basedao.MyMapper;
import io.github.pactstart.system.entity.PlatformNotice;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PlatformNoticeMapper extends MyMapper<PlatformNotice> {

    List<PlatformNotice> query(Object object);

    List<PlatformNotice> queryMyPlatformNotice(@Param("memberId") Integer memberId, @Param("status") Integer status, @Param("readed") Boolean readed);

    @Update("update platform_notice set status=#{status} where id=#{id}")
    int updateStatus(@Param("id") Integer id, @Param("status") int status);

    @Select("select count(1) from platform_notice where status = #{status}")
    int countByStatus(@Param("status") Integer status);

    @Update("update platform_notice set read_count = read_count + 1 where id=#{id}")
    void incrementReadCount(@Param("id") Integer id);
}
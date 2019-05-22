package io.github.pactstart.system.dao;

import io.github.pactstart.basedao.MyMapper;
import io.github.pactstart.system.entity.PlatformNoticeReaded;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PlatformNoticeReadedMapper extends MyMapper<PlatformNoticeReaded> {

    @Select("select count(1) from platform_notice_readed where member_id = #{memberId}")
    int countByMemberId(@Param("memberId") Integer memberId);
}
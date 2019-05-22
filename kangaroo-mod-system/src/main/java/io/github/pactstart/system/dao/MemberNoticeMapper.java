package io.github.pactstart.system.dao;

import io.github.pactstart.basedao.MyMapper;
import io.github.pactstart.system.dto.MemberNoticeQueryDto;
import io.github.pactstart.system.entity.MemberNotice;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MemberNoticeMapper extends MyMapper<MemberNotice> {

    List<MemberNotice> query(MemberNoticeQueryDto queryDto);

    @Update("update member_notice set readed=true where member_id=#{memberId}")
    int updateReadedByMemberId(@Param("memberId") Integer memberId);

    @Update("update member_notice set status=#{status} where id = #{id}")
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);

    @Update("update member_notice set readed=true where id = #{id}")
    int updateReadedById(@Param("id") Long id);

    @Update("update member_notice set nickname=#{newNickname} where member_id=#{memberId}")
    int updateMemberNickname(@Param("memberId") Integer memberId, @Param("newNickname") String newNickname);

    @Select("select count(1) from member_notice where readed=false and member_id=#{memberId}")
    int countUnreadByMemberId(@Param("memberId") Integer memberId);

    void batchUpdateStatus(@Param("noticeIdList") List<Long> noticeIdList, @Param("status") Integer status);
}
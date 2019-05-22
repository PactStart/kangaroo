package io.github.pactstart.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sms_day_count")
public class SmsDayCount {
    /**
     * 自增长主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 年
     */
    private Integer year;

    /**
     * 月
     */
    private Integer month;

    /**
     * 日
     */
    private Integer day;

    /**
     * 增量
     */
    private Integer success;

    /**
     * 总数
     */
    private Integer fail;

    /**
     * 统计时间
     */
    @Column(name = "stat_time")
    private Date statTime;

    /**
     * 获取自增长主键
     *
     * @return id - 自增长主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增长主键
     *
     * @param id 自增长主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取年
     *
     * @return year - 年
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年
     *
     * @param year 年
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取月
     *
     * @return month - 月
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * 设置月
     *
     * @param month 月
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * 获取日
     *
     * @return day - 日
     */
    public Integer getDay() {
        return day;
    }

    /**
     * 设置日
     *
     * @param day 日
     */
    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Integer getFail() {
        return fail;
    }

    public void setFail(Integer fail) {
        this.fail = fail;
    }

    /**
     * 获取统计时间
     *
     * @return stat_time - 统计时间
     */
    public Date getStatTime() {
        return statTime;
    }

    /**
     * 设置统计时间
     *
     * @param statTime 统计时间
     */
    public void setStatTime(Date statTime) {
        this.statTime = statTime;
    }
}
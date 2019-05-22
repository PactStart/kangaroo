package io.github.pactstart.simple.web.framework.common.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class DateBetweenForm {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "开始日期不能为空")
    private Date fromDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "结束日期不能为空")
    private Date toDate;
}

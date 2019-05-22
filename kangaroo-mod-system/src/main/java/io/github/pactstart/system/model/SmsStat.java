package io.github.pactstart.system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SmsStat {

    private Date statDate;

    private int success;

    private int fail;
}

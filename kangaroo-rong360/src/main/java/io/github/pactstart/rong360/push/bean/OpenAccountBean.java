package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OpenAccountBean {


    /**
     * order_no : 245132241561415
     * open_return_url : http://xxxxxxxxxx
     */

    private String order_no;
    private String open_return_url;
}

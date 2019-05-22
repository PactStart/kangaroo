package io.github.pactstart.rong360.push.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class SecondAssayBean {


    /**
     * order_no : 252365274859074
     * score : 4
     * photo_assay : ["https://xxxxxx","https://xxxxxxx","https://xxxxxxx","https://xxxxxxx"]
     * delta_face2 : xxxxxxx
     * assay_type : face++
     */

    private String order_no;
    private String score;
    private String delta_face2;
    private String assay_type;
    private List<String> photo_assay;
}

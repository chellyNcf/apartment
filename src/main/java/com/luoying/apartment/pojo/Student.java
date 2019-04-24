package com.luoying.apartment.pojo;

import lombok.Data;

@Data
public class Student {

    private Long Id=Long.valueOf(1);

    private String name="姓名";

    /**
     * 默认0男1女2
     */
    private Integer sex=1;

    private Integer age=18;

    private String sno="20190420001";

    private String phone="16596328546";

    private String className="222";

    private String departmentName="计算机院系";

    private String apartmentName="学生公寓";

    private String  buildingUnit="A栋1单元";

    private String room="301";

    private String bed="4";

}

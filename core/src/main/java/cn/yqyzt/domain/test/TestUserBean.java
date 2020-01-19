package cn.yqyzt.domain.test;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TestUserBean implements Serializable {

    private Long id;

    private String name;

    private Date birthday;
}

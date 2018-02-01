package com.example.base.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 范例对象:
 *
 * @ Data : 注解在类上, 为类提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
 * @ NoArgsConstructor：注解在类上；为类提供一个无参的构造方法
 * @ AllArgsConstructor：注解在类上；为类提供一个全参的构造方法
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Example {

    private Integer id;

    private String name;
}

package com.chy.dto;

import com.chy.valid.Add;
import com.chy.valid.Update;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author chy
 * @since 2021-03-22 13:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull(message = "id不能为空",groups = {Update.class})
    private Long id;
    @NotBlank(message = "姓名不能为空",groups = {Add.class,Update.class})
    private String name;
    @NotNull(message = "年龄不能为空",groups = {Add.class,Update.class})
    @Min(value = 0,message = "用年龄不能小于0",groups = {Add.class,Update.class})
    private Integer age;
    @NotNull(message = "用户类型不能为空",groups = {Add.class,Update.class})
    private Integer userType;
}

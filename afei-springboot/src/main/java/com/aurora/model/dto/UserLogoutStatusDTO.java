package com.aurora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aFei
 * 登入登出反馈信息类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLogoutStatusDTO {

    private String Message;
}

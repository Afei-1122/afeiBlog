package com.aurora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aFei
 * 社交账号信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SocialUserInfoDTO {

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

}

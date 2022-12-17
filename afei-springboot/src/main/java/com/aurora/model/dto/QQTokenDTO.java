package com.aurora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aFei
 * qq token信息
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QQTokenDTO {

    /**
     * openid
     */
    private String openid;

    /**
     * 客户端id
     */
    private String client_id;

}

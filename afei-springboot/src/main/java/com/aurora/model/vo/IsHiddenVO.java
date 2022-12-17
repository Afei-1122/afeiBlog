package com.aurora.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aFei
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IsHiddenVO {

    private Integer id;

    private Integer isHidden;
}

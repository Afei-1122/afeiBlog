package com.aurora.service;

import com.aurora.model.dto.CommentAdminDTO;
import com.aurora.model.dto.CommentDTO;
import com.aurora.model.dto.ReplyDTO;
import com.aurora.entity.Comment;
import com.aurora.model.vo.CommentVO;
import com.aurora.model.vo.ConditionVO;
import com.aurora.model.vo.PageResult;
import com.aurora.model.vo.ReviewVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CommentService extends IService<Comment> {

    void saveComment(CommentVO commentVO);

    PageResult<CommentDTO> listComments(CommentVO commentVO);

    List<ReplyDTO> listRepliesByCommentId(Integer commentId);

    List<CommentDTO> listTopSixComments();

    PageResult<CommentAdminDTO> listCommentsAdmin(ConditionVO conditionVO);

    void updateCommentsReview(ReviewVO reviewVO);

}
package com.aurora.controller;

import com.aurora.annotation.OptLog;
import com.aurora.enums.FilePathEnum;
import com.aurora.model.dto.PhotoAdminDTO;
import com.aurora.model.dto.PhotoDTO;
import com.aurora.service.PhotoService;
import com.aurora.model.vo.*;
import com.aurora.strategy.context.UploadStrategyContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

import static com.aurora.constant.OptTypeConstant.*;


/**
 * @author aFei
 */
@Api(tags = "照片模块")
@RestController
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private UploadStrategyContext uploadStrategyContext;

    @OptLog(optType = UPLOAD)
    @ApiOperation(value = "上传照片")
    @ApiImplicitParam(name = "file", value = "照片", required = true, dataType = "MultipartFile")
    @PostMapping("/admin/photos/upload")
    public Result<String> savePhotoAlbumCover(MultipartFile file) {
        return Result.ok(uploadStrategyContext.executeUploadStrategy(file, FilePathEnum.PHOTO.getPath()));
    }

    @ApiOperation(value = "根据相册id获取照片列表")
    @GetMapping("/admin/photos")
    public Result<PageResult<PhotoAdminDTO>> listPhotos(ConditionVO conditionVO) {
        return Result.ok(photoService.listPhotos(conditionVO));
    }

    @OptLog(optType = UPDATE)
    @ApiOperation(value = "更新照片信息")
    @PutMapping("/admin/photos")
    public Result<?> updatePhoto(@Valid @RequestBody PhotoInfoVO photoInfoVO) {
        photoService.updatePhoto(photoInfoVO);
        return Result.ok();
    }

    @OptLog(optType = SAVE)
    @ApiOperation(value = "保存照片")
    @PostMapping("/admin/photos")
    public Result<?> savePhotos(@Valid @RequestBody PhotoVO photoVO) {
        photoService.savePhotos(photoVO);
        return Result.ok();
    }

    @OptLog(optType = UPDATE)
    @ApiOperation(value = "移动照片相册")
    @PutMapping("/admin/photos/album")
    public Result<?> updatePhotosAlbum(@Valid @RequestBody PhotoVO photoVO) {
        photoService.updatePhotosAlbum(photoVO);
        return Result.ok();
    }

    @OptLog(optType = UPDATE)
    @ApiOperation(value = "更新照片删除状态")
    @PutMapping("/admin/photos/delete")
    public Result<?> updatePhotoDelete(@Valid @RequestBody DeleteVO deleteVO) {
        photoService.updatePhotoDelete(deleteVO);
        return Result.ok();
    }

    @OptLog(optType = DELETE)
    @ApiOperation(value = "删除照片")
    @DeleteMapping("/admin/photos")
    public Result<?> deletePhotos(@RequestBody List<Integer> photoIds) {
        photoService.deletePhotos(photoIds);
        return Result.ok();
    }

    @ApiOperation(value = "根据相册id查看照片列表")
    @GetMapping("/albums/{albumId}/photos")
    public Result<PhotoDTO> listPhotosByAlbumId(@PathVariable("albumId") Integer albumId) {
        return Result.ok(photoService.listPhotosByAlbumId(albumId));
    }

}

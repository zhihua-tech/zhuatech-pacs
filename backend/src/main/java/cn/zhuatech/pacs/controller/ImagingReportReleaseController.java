/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.pacs.controller;

import cn.zhuatech.pacs.common.ApiResponse;
import cn.zhuatech.pacs.service.ImagingReportReleaseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/enterprise/pacs")
public class ImagingReportReleaseController {
    private final ImagingReportReleaseService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public ImagingReportReleaseController(ImagingReportReleaseService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/imaging-report-release")
    public ApiResponse<ImagingReportReleaseService.Assessment> assess(
            @Valid @RequestBody ImagingReportReleaseService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}

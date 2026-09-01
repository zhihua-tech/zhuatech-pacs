/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.pacs.controller;

import cn.zhuatech.pacs.common.ApiResponse;
import cn.zhuatech.pacs.service.ImagingReportReleaseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enterprise/pacs")
public class ImagingReportReleaseController {
    private final ImagingReportReleaseService service;
    public ImagingReportReleaseController(ImagingReportReleaseService service) { this.service = service; }
    @PostMapping("/imaging-report-release")
    public ApiResponse<ImagingReportReleaseService.Assessment> assess(
            @Valid @RequestBody ImagingReportReleaseService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}

/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.pacs.controller;
import cn.zhuatech.pacs.common.ApiResponse;import cn.zhuatech.pacs.service.ImagingWorklistPriorityService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/pacs/insights/worklist-priority") public class ImagingWorklistPriorityController {private final ImagingWorklistPriorityService service;public ImagingWorklistPriorityController(ImagingWorklistPriorityService service){this.service=service;}@PostMapping ApiResponse<ImagingWorklistPriorityService.Result> prioritize(@Valid @RequestBody ImagingWorklistPriorityService.Request request){return ApiResponse.ok(service.prioritize(request));}}

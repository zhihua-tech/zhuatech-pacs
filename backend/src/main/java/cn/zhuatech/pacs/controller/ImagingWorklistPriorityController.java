/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.pacs.controller;
import cn.zhuatech.pacs.common.ApiResponse;import cn.zhuatech.pacs.service.ImagingWorklistPriorityService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/pacs/insights/worklist-priority") public class ImagingWorklistPriorityController {private final ImagingWorklistPriorityService service;/**
                                                                                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                              */
public ImagingWorklistPriorityController(ImagingWorklistPriorityService service){this.service=service;}/**
                                                                                                                                                                                                                                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                     */
@PostMapping ApiResponse<ImagingWorklistPriorityService.Result> prioritize(@Valid @RequestBody ImagingWorklistPriorityService.Request request){return ApiResponse.ok(service.prioritize(request));}}

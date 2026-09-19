/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.pacs;
import cn.zhuatech.pacs.service.ImagingWorklistPriorityService;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class ImagingWorklistPriorityServiceTests {private final ImagingWorklistPriorityService service=new ImagingWorklistPriorityService();
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Test void escalatesEmergencyCriticalStudy(){var r=service.prioritize(new ImagingWorklistPriorityService.Request("S1","CT",10,30,true,true,false,false));assertEquals("STAT",r.priority());}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Test void retainsRoutineStudy(){var r=service.prioritize(new ImagingWorklistPriorityService.Request("S2","MR",5,60,false,false,false,false));assertEquals("ROUTINE",r.priority());assertFalse(r.slaBreached());}}

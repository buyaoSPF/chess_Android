package com.zxyp.form.precisePlan.list;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.zxyp.base.PageQuery;

import lombok.Data;

@Data
public class PlanForm extends PageQuery {

	private String endTime; //工程竣工时间

	private String cityName; // 地市州

	private String stationName; // 基站名

	private String enbId;// private Integer enbId; //EnbID

	private String projectName; // 工程名字

	private String siteId; // 基站id(编号)

	private String code; // 规划id(编号)

	private Integer cellNum;// 小区数

	private Integer status; // 状态(开通，未开通) 查状态看6/7/8，6/7是未开通

	private Integer isUpload;// 0或null否，1是；是否上传 主表code left join关联上传记录表，取批次最大的一次的上传时间，没有的就是没有上传，否

	private Date uploadSchedule;// 文件上传时间

}

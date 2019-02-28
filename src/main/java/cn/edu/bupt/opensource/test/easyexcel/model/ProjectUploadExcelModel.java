package cn.edu.bupt.opensource.test.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * 项目模型
 * @author chengtf
 * @date 2019/2/28
 */
@Data
public class ProjectUploadExcelModel extends BaseRowModel {

    @ExcelProperty(index = 0)
    private String poiId;

    @ExcelProperty(index = 1)
    private String projectType;

    @ExcelProperty(index = 2)
    private String planStartTime;

    @ExcelProperty(index = 3)
    private String planEndTime;

    @ExcelProperty(index = 4)
    private String projectMean;

    @ExcelProperty(index = 5)
    private String planGrossIncome;

    @ExcelProperty(index = 6)
    private String planCouponNum;

    @ExcelProperty(index = 7)
    private String projectStatus;

    @ExcelProperty(index = 8)
    private String remark;

}

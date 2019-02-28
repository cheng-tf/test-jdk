package cn.edu.bupt.opensource.test.easyexcel.listener;

import cn.edu.bupt.opensource.test.easyexcel.model.ProjectUploadExcelModel;
import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @author chengtf
 * @date 2019/2/28
 */
public class ProjectUploadListener extends AnalysisEventListener<ProjectUploadExcelModel> {

    private List<ProjectUploadExcelModel> projectUploadExcelModels;

    public ProjectUploadListener(List<ProjectUploadExcelModel> projectUploadExcelModels) {
        this.projectUploadExcelModels = projectUploadExcelModels;
    }

    @Override
    public void invoke(ProjectUploadExcelModel projectUploadExcelModel, AnalysisContext context) {
        // ProjectUploadExcelModel projectUploadExcelModel = (ProjectUploadExcelModel) object;
        System.out.println("------" + context.getCurrentRowNum());
        projectUploadExcelModels.add(projectUploadExcelModel);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("----------end------");
    }

}
